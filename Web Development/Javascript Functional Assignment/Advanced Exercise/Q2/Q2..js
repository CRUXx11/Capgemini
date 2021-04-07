
function find(a,function isEven(num) {
    return num % 2 == 0;
  }) {
  if (isEven(a[a.length - 1])) {
    document.getElementById("result").innerHTML = a[a.length - 1];
  }
  a.pop();
  find(a);
}
find([1, 3, 5, 4, 2], isEven);

