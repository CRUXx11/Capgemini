for (let i = 0; i < 3; i++) {
    var a = prompt("Enter number between 1 and 30");
    if (a > 0 && a < 31) {
        for (let j = 0; j < a; j++) {
            document.write("*");
        }
        document.write("<br>");
    }
    else {
        document.write("Invalid number<br>");
    }
}

