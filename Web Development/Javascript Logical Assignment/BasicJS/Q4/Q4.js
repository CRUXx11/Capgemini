var x = document.getElementById('bu');
x.addEventListener('click', function (e) {
    e.preventDefault();
    let a = document.getElementById('text').value;
    let x = 0;
    let m = [];
    for (let i = 0; i < a.length; i++){
        if (a[i] != "a" && a[i] != "b") {
            let j = i;
            while (a[j] != 'a' && a[j] != 'b') {
                j++;
            }
            m[x] = a.substring(i, j);
            x++;
        }
    }
    if (m.length > 0) {
        let p = 0;
        let q = 0;
        for (let i = 0; i < m.length; i++) {
            if (m[i].length > p) {
                p = m[i].length;
                q = i;
            }
        }
    document.getElementById("result").innerHTML = '"' + m[q] + '"';
    }
    else {
        document.getElementById("result").innerHTML = '"' +  '"';
    }})

