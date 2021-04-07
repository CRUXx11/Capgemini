var a = prompt("Enter rows");
var b = prompt("Enter columns");
var theader = '<table border="1">\n';
var tbody = '';
for( var i=0; i<a;i++)
    {
        tbody += '<tr>';
        for( var j=0; j<b;j++)
        {
            tbody += '<td>';
            tbody += 'row' + (i+1) + ',col' + (j+1);
            tbody += '</td>'
        }
        tbody += '</tr>\n';
}
var tfooter = '</table>';
document.getElementById('result').innerHTML = theader + tbody + tfooter;