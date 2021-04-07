var x = document.getElementById('bu');
x.addEventListener('click', function (e) {
    e.preventDefault();
    let f = document.getElementById('num').value;
    if (f != "") {
        let c = ((f - 32) * 5) / 9;
        document.getElementById('result').innerHTML = c + " degree celcius";
    }
    else {
        document.getElementById('result').innerHTML =  "Enter a number";
    }
})

