<%
String bgColor = "white";
String selectedColor = request.getParameter("color");
if (selectedColor != null && !selectedColor.isEmpty()) {
    Cookie colorCookie = new Cookie("bgColor", selectedColor);
    colorCookie.setMaxAge(60 * 60 * 24 * 7);
    response.addCookie(colorCookie);
    bgColor = selectedColor;
}
else {
    Cookie[] cookies = request.getCookies();
    if ("bgColor".equals(cookies[0].getName())) {
        bgColor = cookies[0].getValue();
    }
}
%>
<body style="background-color: <%= bgColor %>;">
    <h1>Select a Background Color</h1>
    <form method="post">
        Choose a color:<input type="color" name="color" value="<%= bgColor %>">
        <br><br>
        <input type="submit" value="Change Background Color">
    </form>
</body>