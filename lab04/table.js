function onClickAddBook() {
    var str1 = new RegExp("^[a-zA-Z0-9\u4e00-\u9fa5]{1,}$");
    var str2 = new RegExp("^[A-Z][a-zA-Z]+$");
    var str3 = new RegExp("^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$");
    var str4 = new RegExp("^[0-9]{4,4}$");
    var str5 = new RegExp("^(0?[1-9]|1[0-2])$");
    var str6 = new RegExp("^(0?[1-9]|[1-2]\d|3[0-1])$");
    var bknm = document.getElementById("bookname").value;
    var au = document.getElementById("author").value;
    var pri = document.getElementById("price").value;
    var year=document.getElementById("year").value;
    var month=document.getElementById("month").value;
    var day=document.getElementById("day").value;
    if (!str1.test(bknm)) {
        alert("Bookname error: you can only input alphabets,figures and Chinese characters");
        document.getElementById("bookname").focus();
        return;
    }
    if (!str2.test(au)) {
        alert("Author error: you can only input an English name");
        document.getElementById("author").focus();
        return;
    }
    if (!str3.test(pri)) {
        alert("Price error: you can only input an float figures whose value is larger than zero");
        document.getElementById("price").focus();
        return;
    }
    if (!str4.test(year)) {
        alert("Invalid input: please choose a year");
        document.getElementById("year").focus();
        return;
    }
    if (!str5.test(month)) {
        alert("Invalid input: please choose a month");
        document.getElementById("month").focus();
        return;
    }
    if (!str6.test(day)) {
        alert("Invalid input: please choose a day");
        document.getElementById("day").focus();
        return;
    }
    addRow();
}



function initial() {
    var year = document.getElementById("year");
    year.innerHTML = ""
    for (var i = 0; i < year.childNodes.length; i++) {
        year.removeChild(area.options[0]);
        year.remove(0);
        year.options[0] = null;
    }
    year.options.add(new Option("Year", 0));
    for (var i = 2000; i <= 2017; i++) {
        year.options.add(new Option(i, i));
    }
}

function setMonth() {
    var month = document.getElementById("month");
    month.innerHTML = ""
    for (var i = 0; i < month.childNodes.length; i++) {
        month.removeChild(area.options[0]);
        month.remove(0);
        month.options[0] = null;
    }
    month.options.add(new Option("Month", 0));
    for (var i = 1; i <= 12; i++) {
        month.options.add(new Option(i, i));
    }
}

function setDay() {
    var year = document.getElementById("year").value;
    var month = document.getElementById("month").value;
    var day = document.getElementById("day");
    var data = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
    day.innerHTML = ""
    for (var i = 0; i < day.childNodes.length; i++) {
        day.removeChild(area.options[0]);
        day.remove(0);
        day.options[0] = null;
    }
    day.options.add(new Option("Day", 0));
    for (var i = 1; i <= data[month - 1]; i++) {
        day.options.add(new Option(i, i));
    }
    if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) && month == 2) {
        day.options.add(new Option(29, 29));
    }
}

function get(){
    var value='';
    var radio = document.getElementsByName("radio");
    for(var i = 0;i<radio.length;i++)
    {
        if(radio[i].checked==true)
        {value = radio[i].value;
            break;}
    }
    return value;
}

function addRow() {
    var bodyObj = document.getElementById("tbody");
    if (bodyObj == null) {
        alert("Body of Table not Exist!");
        return;
    }
    var rowCount = bodyObj.rows.length;
    var cellCount = bodyObj.rows[0].cells.length;
    bodyObj.style.display = "";
    var newRow = bodyObj.insertRow(rowCount++);
    newRow.insertCell(0).innerHTML = document.getElementById("bookname").value;
    newRow.insertCell(1).innerHTML = document.getElementById("author").value;
    newRow.insertCell(2).innerHTML = document.getElementById("price").value;
    newRow.insertCell(3).innerHTML = document.getElementById("year").value + "." +
        document.getElementById("month").value + "." + document.getElementById("day").value;
    newRow.insertCell(4).innerHTML = get();
    newRow.insertCell(5).innerHTML = bodyObj.rows[0].cells[cellCount - 1].innerHTML;
    //newRow.insertCell(4).innerHTML = bodyObj.rows[0].cells[cellCount - 1].innerHTML;
    bodyObj.rows[0].style.display = "none";
}

function removeRow(inputobj)
{
    if(inputobj==null) return;
    var parentTD = inputobj.parentNode;
    var parentTR = parentTD.parentNode;
    var parentTBODY = parentTR.parentNode; parentTBODY.removeChild(parentTR);
}