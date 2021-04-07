var val = document.getElementById('bu');
val.addEventListener('click', function parity(e) {
    e.preventDefault();
    var ad = document.getElementById('num').value;
    if (ad % 2 == 0) {
        document.getElementById('result').innerHTML = ad + " is an even number.";
    } else {
        document.getElementById('result').innerHTML = ad + " is an odd number.";
    }

})