<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script type="text/javascript">

      $(document).ready(function() {
          loadCategories();
      });

      var serviceNews = '/news';
      var serviceCategory = '/category';

      var restGet = function () {
          $.ajax({
              type: 'GET',
              url: serviceNews + "/list",
              dataType: 'json',
              async: false,
              success: function (result) {
                  loadWords(result);
              },
              error: function (jqXHR, textStatus, errorThrown) {

              }
          });
      };

      var restSearchByName = function () {
          $.ajax({
              type: 'POST',
              url: serviceNews + "/searchByName",
              contentType: 'application/json',
              data: $('#nameNews').val(),
              dataType: 'json',
              async: false,
              success: function (result) {
                  loadWords(result);
              },
              error: function (jqXHR, textStatus, errorThrown) {

              }
          });
      };

      var restSearchByContent = function () {
          $.ajax({
              type: 'POST',
              url: serviceNews + "/searchByContent",
              contentType: 'application/json',
              data: $('#contentNews').val(),
              dataType: 'json',
              async: false,
              success: function (result) {
                  loadWords(result);
              },
              error: function (jqXHR, textStatus, errorThrown) {

              }
          });
      };

      var restSearchByCategory = function () {
          var selector = document.getElementById('category');
          var value = selector[selector.selectedIndex].value;
          $.ajax({
              type: 'POST',
              url: serviceCategory + "/searchByCategory",
              contentType: 'application/json',
              data: value,
              dataType: 'json',
              async: false,
              success: function (result) {
                  loadWords(result);
              },
              error: function (jqXHR, textStatus, errorThrown) {

              }
          });
      };


      var restAddNews = function () {
          var selector = document.getElementById('category');
          var value = selector[selector.selectedIndex].value;
          var jsonObj = {};
          jsonObj["name"] = $('#nameNews').val();
          jsonObj["content"] = $('#contentNews').val();
          jsonObj["date"] = $('#date').val();
          jsonObj["categoryID"] = value;

          $.ajax({
              type: 'POST',
              url: serviceNews + "/add",
              contentType: 'application/json',
              data: JSON.stringify(jsonObj),
              dataType: 'json',
              async: false,
              success: function (result) {
                  loadWords(result);
              },
              error: function (jqXHR, textStatus, errorThrown) {

              }
          });
      };

      var restAddCategory = function () {
          $.ajax({
              type: 'POST',
              url: serviceCategory + "/add",
              contentType: 'application/json; charset=utf-8',
              data: $('#name').val(),
              dataType: 'json',
              async: false,
              success: function (result) {
                  populate(result);
              },
              error: function (jqXHR, textStatus, errorThrown) {

              }
          });
      };

      function restRemoveNews(id) {
          $.ajax({
              type: 'POST',
              url: serviceNews + "/remove",
              contentType: 'application/json; charset=utf-8',
              data: JSON.stringify(id),
              dataType: 'json',
              async: false,
              success: function (result) {
                  loadWords(result);
              },
              error: function (jqXHR, textStatus, errorThrown) {

              }
          });
      };

      function restUpdateNews(id) {
          var selector = document.getElementById('category');
          var value = selector[selector.selectedIndex].value;
          var jsonObj = {};
          jsonObj["id"] = id;
          jsonObj["name"] = $('#nameNews').val();
          jsonObj["content"] = $('#contentNews').val();
          jsonObj["date"] = $('#date').val();
          jsonObj["categoryID"] = value;
          $.ajax({
              type: 'POST',
              url: serviceNews + "/update",
              contentType: 'application/json; charset=utf-8',
              data: JSON.stringify(jsonObj),
              dataType: 'json',
              async: false,
              success: function (result) {
                  loadWords(result);
              },
              error: function (jqXHR, textStatus, errorThrown) {

              }
          });
      };

      var loadWords = function(result) {
          var table = "";
          if (Array.isArray(result)) {
              var size = result.length;
          }

          if (Array.isArray(result)) {
              for(var i = 0; i != size; i++){
                  table += "<tr><td>#</td><td>" +result[i].name + "</td><td>" +result[i].content + "</td><td>" + new Date(result[i].date)  + "</td><td>" + result[i].category.name + "</td><td><button type='button' onclick='restRemoveNews(" + result[i].id + ")'>Удалить</button></td><td><button type='button' onclick='restUpdateNews(" + result[i].id + ")'>Update</button></td></tr>"
              }
          } else{
              table += "<tr><td>#</td><td>" +result.name + "</td><td>" + result.content + "</td><td>" + Date(result.date) + "</td><td>" + result.category.name + "</td><td><button type='button' onclick='restRemoveNews(" + result.id + ")'>Удалить</button></td><td><button type='button' onclick='restUpdateNews(" + result.id + ")'>Update</button></td></tr>"
          }

          $('#response').html(table);
      };

      var loadCategories = function () {
          $.ajax({
              type: 'GET',
              url: serviceCategory + "/list",
              dataType: 'json',
              async: false,
              success: function (result) {
                  populate(result);
              },
              error: function (jqXHR, textStatus, errorThrown) {

              }
          });
      };

      function populate(result)
      {
          var category = $('#category').html('');

          if (Array.isArray(result)) {
              var size = result.length;
          }

          if (Array.isArray(result)) {
              for(var i = 0; i < size; i++){
                  category.append('<option value="' + result[i].id + '">' + result[i].name + '</option>');
              }
          } else{
              category.append('<option value="' + result.id + '">' + result.name + '</option>');
          }

      }
  </script>
</head>
<body>

<button type='button' onclick='restGet()'>Show News list</button>
<button type='button' onclick='restAddCategory()'>Add Category</button>
<button type='button' onclick='restAddNews()'>Add News</button>
<button type='button' onclick='restSearchByName()'>Search By Name</button>
<button type='button' onclick='restSearchByContent()'>Search By Content</button>
<button type='button' onclick='restSearchByCategory()'>Search By Category</button>
<br/>
<label for="name">Название категории</label><input id="name" type='text' name='test' />
<br/>
<label for="nameNews">Название Новости</label><input id="nameNews" type='text'/>
<br/>
<label for="contentNews">Контент</label><input id="contentNews" type='text'/>
<br/>
<label for="date">Дата</label><input id="date" type='date' />
<br/>
<label for="category">Категория</label><select id="category">

</select>

<table>
  <thead>
  <tr>
      <th>#</th>
      <th>Name</th>
      <th>Content</th>
      <th>Date</th>
      <th>Category name</th>
  </tr>
  </thead>
  <tbody id="response">

  </tbody>
</table>


</body>
</html>