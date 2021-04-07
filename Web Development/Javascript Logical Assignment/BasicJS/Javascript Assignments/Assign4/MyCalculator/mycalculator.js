function AutoRefresh( t ) {
    setTimeout("location.reload(true);", t);
  }
var b = prompt(
  "1.Add\n2.Subtract\n3.Multiply\n4.Divide\n5.Exponent\n6.Mean\n7.Quit"
);
var a = parseInt(b);
if (a < 1 || a > 7) {
  alert("Enter a valid number");
  document.location.reload();
}
else {
  switch (a) {
    case 1:
      var c = prompt("Enter 1st number");
      var d = prompt("Enter 2nd number");
      document.getElementById("result").style.fontSize = "xx-large";
      document.getElementById("re").style.fontSize = "xx-large";
      document.getElementById("re").innerHTML = "Result<br>";
      document.getElementById("result").innerHTML = parseInt(c) + parseInt(d);
      break;
    case 2:
      var c = prompt("Enter 1st number");
      var d = prompt("Enter 2nd number");
      document.getElementById("result").style.fontSize = "xx-large";
      document.getElementById("re").style.fontSize = "xx-large";
      document.getElementById("re").innerHTML = "Result<br>";
      document.getElementById("result").innerHTML = parseInt(c) - parseInt(d);
      break;
    case 3:
      var c = prompt("Enter 1st number");
      var d = prompt("Enter 2nd number");
      document.getElementById("result").style.fontSize = "xx-large";
      document.getElementById("re").style.fontSize = "xx-large";
      document.getElementById("re").innerHTML = "Result<br>";
      document.getElementById("result").innerHTML = parseInt(c) * parseInt(d);
      break;
    case 4:
      var c = prompt("Enter 1st number");
      var d = prompt("Enter 2nd number");
      document.getElementById("result").style.fontSize = "xx-large";
      document.getElementById("re").style.fontSize = "xx-large";
      document.getElementById("re").innerHTML = "Result<br>";
      document.getElementById("result").innerHTML = parseInt(c) / parseInt(d);
      break;
    case 5:
      var c = prompt("Enter 1st number");
      var d = prompt("Enter 2nd number");
      document.getElementById("result").style.fontSize = "xx-large";
      document.getElementById("re").style.fontSize = "xx-large";
      document.getElementById("re").innerHTML = "Result<br>";
      document.getElementById("result").innerHTML = Math.pow(
        parseInt(c),
        parseInt(d)
      );
      break;
    case 6:
      var c = "";
      var d = 0;
      var e = 0;
      while (c != "***") {
        var f = prompt("Enter a number or *** to stop");
        if (f == "***") {
          break;
        } else {
          c = f;
          f = parseInt(f);
          d = parseInt(d) + f;
          e += 1;
        }
      }
      document.getElementById("result").style.fontSize = "xx-large";
      document.getElementById("re").style.fontSize = "xx-large";
      document.getElementById("re").innerHTML = "Result<br>";
      document.getElementById("result").innerHTML = d / f;
      break;
    }
}
AutoRefresh(3000);

// var b = prompt("Enter columns");
// var theader = '<table border="1">\n';
// var tbody = '';
// for( var i=0; i<a;i++)
//     {
//         tbody += '<tr>';
//         for( var j=0; j<b;j++)
//         {
//             tbody += '<td>';
//             tbody += 'row' + (i+1) + ',col' + (j+1);
//             tbody += '</td>'
//         }
//         tbody += '</tr>\n';
// }
// var tfooter = '</table>';
// document.getElementById('result').innerHTML = theader + tbody + tfooter;
