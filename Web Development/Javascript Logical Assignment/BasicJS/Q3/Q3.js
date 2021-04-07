let n = ["1.2", "1.3", "1.4"];
let a=[]
for (let i = 0; i < 3; i++){
    a[i] = parseFloat(n[i]);
}
document.getElementById("result").innerHTML ="["+ a+"]";
