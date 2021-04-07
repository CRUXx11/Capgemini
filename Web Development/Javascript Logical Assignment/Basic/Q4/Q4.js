var val = document.getElementById('bu');
val.addEventListener('click', function headsratio(e) {
    e.preventDefault();
    var x = document.getElementById('num1').value;
    let n=0;
    for(let i=0;i<x;i++){
            let a = (Math.floor(Math.random() * 2) == 0);
        if(a){
            n = n + 1;
        }
    }
    document.getElementById('result').innerHTML ="number of heads is "+ n/x;
})