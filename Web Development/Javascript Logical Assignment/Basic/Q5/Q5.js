var val = document.getElementById('bu');
val.addEventListener('click', function padChars(e) {
    e.preventDefault();
    var x = document.getElementById('num1').value;
    var y = document.getElementById('text1').value;
    for(let i=0;i<x;i++){
        document.getElementById('result').innerHTML =document.getElementById('result').innerHTML+y;           
    }
})