var val = document.getElementById('bu');
val.addEventListener('click', function max(e) {
    e.preventDefault();
    var a = document.getElementById('num1').value;
    var b = document.getElementById('num2').value;
    var c = document.getElementById('num3').value;
    if (a>b && a>c) {
        document.getElementById('result').innerHTML ="max number is "+ a;
    } else if(b>a && b>c){
        document.getElementById('result').innerHTML ="max number is "+ b ;
    }
    else {
        document.getElementById('result').innerHTML = "max number is "+c ;
    }

})