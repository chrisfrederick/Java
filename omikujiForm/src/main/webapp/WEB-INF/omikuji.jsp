<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
<h3>Send an Omikuji!</h3>
<form action="/form" method="post">
    <label>Pick any number 5 to 25:</label><br>
    <select name="number">
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
        <option value="13">13</option>
        <option value="14">14</option>
        <option value="15">15</option>
        <option value="16">16</option>
        <option value="17">17</option>
        <option value="18">18</option>
        <option value="19">19</option>
        <option value="20">20</option>
        <option value="21">21</option>
        <option value="22">22</option>
        <option value="23">23</option>
        <option value="24">24</option>
        <option value="25">25</option>
    </select><br><br>
    <label>Enter the name of any city</label><br>
    <input type="text" name="city"><br><br>

    <label>Enter the name of the person</label><br>
    <input type="text" name="person"><br><br>

    <label>Enter professional endeavor or hobby</label><br>
    <input type="text" name="hobby"><br><br>

    <label>Enter any type of living thing</label><br>
    <input type="text" name="thing"><br><br>

    <label>Say something nice to someone</label><br>
    <input type="text" name="nice"><br><br>

    <input type="submit" value="send"><br>

</form>
</body>
</html>