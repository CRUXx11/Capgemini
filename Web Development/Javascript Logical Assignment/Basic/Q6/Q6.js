var val = document.getElementById('bu');
val.addEventListener('click', function numRollstogetsix(e) {
    e.preventDefault();
    var n = 0,a=0;
    while (n != 6) {
        a = a + 1;
        n = Math.floor(Math.random() * 6) + 1;

    }
    document.getElementById('result').innerHTML =a;
})