var x = document.getElementById('bu');
var y = new Array();
var z = 0;
x.addEventListener('click', function (e) {
    e.preventDefault();
    let a = document.getElementById('text').value;
    y.push(a);
    if (a.includes('q') != true) {
        z = z + a.length;
    }
    document.getElementById('result').innerHTML = y;
    document.getElementById('result1').innerHTML = z;
    })

