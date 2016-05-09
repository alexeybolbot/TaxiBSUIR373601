function createRequest() 
{
    try {
    request = new XMLHttpRequest();
    } catch (trymicrosoft) {
    try {
    request = new ActiveXObject("MsXML2.XMLHTTP");
    } catch (othermicrosoft) {
    try {
    request = new ActiveXObject("Microsoft.XMLHTTP");
    } catch (failed) {
    request = null;
    }
    }
    }

    if (request == null)
    alert("Error creating request object!");
}

function Registration()
{
	createRequest(); 
	var firstname = document.getElementById('firstnameReg').value; 
	var lastname = document.getElementById('lastnameReg').value; 
	var address = document.getElementById('addressReg').value; 
	var phone = document.getElementById('phoneReg').value;
	var password1 = document.getElementById('passwordReg').value; 	
	var params = "{\"firstname\":\""+firstname+"\",\"lastname\":\""+lastname+"\",\"address\":\""+address+"\",\"phone\":\""+phone+"\",\"password\":\""+password1+"\"}"; 
	var url = "http://localhost:8080/Restful5/webresources/rest.user/register"; 
	request.open("POST", url, true); 
	request.setRequestHeader('Content-Type', 'application/json'); 
	request.send(params); 
        location.reload()

}

function carInsert()
{
	createRequest(); 
	var modelCar = "lada";
	var placesCar = 4; 
	var colorCar = "baklajan";
	var params = "{\"modelCar\":\""+modelCar+"\",\"placesCar\":\""+placesCar+"\",\"colorCar\":\""+colorCar+"\"}"; 
	var url = "http://localhost:8080/Restful5/webresources/rest.car/create"; 
	request.open("POST", url, true); 
	request.setRequestHeader('Content-Type', 'application/json'); 
	request.send(params); 
}

function insertVacancy()
{
	createRequest(); 
	var firstname = document.getElementById('firstnameVacancy').value; 
	var lastname = document.getElementById('lastnameVacancy').value; 
	var sex = document.getElementById('sexVacancy').value; 
	var modelcar = document.getElementById('modelcarVacancy').value;
	var placescar = document.getElementById('placescarVacancy').value; 
        var colorcar = document.getElementById('colorcarVacancy').value; 
        var contact = document.getElementById('contactVacancy').value; 
        alert("1");
	var params = "{\"firstname\":\""+firstname+"\",\"lastname\":\""+lastname+"\",\"sex\":\""+sex+"\",\"modelcar\":\""+modelcar+"\",\"placescar\":\""+placescar+"\",\"colorcar\":\""+colorcar+"\",\"contact\":\""+contact+"\"}"; 
	var url = "http://localhost:8080/Restful5/webresources/rest.vacant/create"; 
	request.open("POST", url, true); 
	request.setRequestHeader('Content-Type', 'application/json'); 
	request.send(params); 
         alert("1");
        location.reload();
}

var checkboxCount = 0;
var checkboxCountVacant = 0;
var chetVacant = 0;
var chetCar = 0;

function acceptOrders()
{
    for(var i=0; i<checkboxCount; i++)
    {
        if($("#checkboxOrder"+i).prop('checked'))
        {
            var tableOrder = document.getElementById("lftable");
            var emailTr = tableOrder.rows[i+1];
            var emailTd = emailTr.cells[1];
            var email = emailTd.innerHTML;
            var mas1 = email.split("<center>");
            var mas2 = mas1[1].split("</center>");
            
            alert(mas2[0]);
            var idOrder = mas2[0];
            emailTr = tableOrder.rows[i+1];
            emailTd = emailTr.cells[7];
            email = emailTd.innerHTML;
            mas1 = email.split("<center>");
            mas2 = mas1[1].split("</center>");
            
            alert(mas2[0]);
            var idClient = mas2[0];
            createRequest(); 
            var params = "{\"idOrder\":\""+idOrder+"\",\"idClient\":\""+idClient+"\"}"; 
            var url = "http://localhost:8080/Restful5/webresources/rest.order1/accept"; 
            request.open("POST", url, true); 
            request.setRequestHeader('Content-Type', 'application/json'); 
            request.send(params); 
        }
    }
    location.reload();
}

function acceptCandidates()
{
    for(var i=0; i<checkboxCountVacant; i++)
    {
        if($("#checkboxVacant"+i).prop('checked'))
        {
            var tableOrder = document.getElementById("prtable");
            var emailTr = tableOrder.rows[i+1];
            var emailTd = emailTr.cells[1];
            var email = emailTd.innerHTML;
            var mas1 = email.split("<center>");
            var mas2 = mas1[1].split("</center>");
            
            alert(mas2[0]);
            var idVac = mas2[0];
            
            var emailTr = tableOrder.rows[i+1];
            var emailTd = emailTr.cells[3];
            var email = emailTd.innerHTML;
            var mas1 = email.split("<center>");
            var mas2 = mas1[1].split("</center>");
            
            alert(mas2[0]);
            var firstname = mas2[0];
            emailTr = tableOrder.rows[i+1];
            emailTd = emailTr.cells[4];
            email = emailTd.innerHTML;
            mas1 = email.split("<center>");
            mas2 = mas1[1].split("</center>");
            
            alert(mas2[0]);
            var lastname = mas2[0];
            
            emailTr = tableOrder.rows[i+1];
            emailTd = emailTr.cells[5];
            email = emailTd.innerHTML;
            mas1 = email.split("<center>");
            mas2 = mas1[1].split("</center>");
            
            alert(mas2[0]);
            var sex = mas2[0];
            
            emailTr = tableOrder.rows[i+1];
            emailTd = emailTr.cells[6];
            email = emailTd.innerHTML;
            mas1 = email.split("<center>");
            mas2 = mas1[1].split("</center>");
            
            alert(mas2[0]);
            var modelcar = mas2[0];
            
            emailTr = tableOrder.rows[i+1];
            emailTd = emailTr.cells[7];
            email = emailTd.innerHTML;
            mas1 = email.split("<center>");
            mas2 = mas1[1].split("</center>");
            
            alert(mas2[0]);
            var placescar = mas2[0];
            
            emailTr = tableOrder.rows[i+1];
            emailTd = emailTr.cells[8];
            email = emailTd.innerHTML;
            mas1 = email.split("<center>");
            mas2 = mas1[1].split("</center>");
            
            alert(mas2[0]);
            var colorcar = mas2[0];
            
            emailTr = tableOrder.rows[i+1];
            emailTd = emailTr.cells[9];
            email = emailTd.innerHTML;
            mas1 = email.split("<center>");
            mas2 = mas1[1].split("</center>");
            
            alert(mas2[0]);
            var contact = mas2[0];
            
            createRequest(); 
            var params = "{\"idVac\":\""+idVac+"\",\"firstname\":\""+firstname+"\",\"lastname\":\""+lastname+"\",\"sex\":\""+sex+"\",\"modelcar\":\""+modelcar+"\",\"placescar\":\""+placescar+"\",\"colorcar\":\""+colorcar+"\",\"contact\":\""+contact+"\"}"; 
            var url = "http://localhost:8080/Restful5/webresources/rest.vacant/accept"; 
            request.open("POST", url, true); 
            request.setRequestHeader('Content-Type', 'application/json'); 
            request.send(params); 
        }
    }
    location.reload();
}


function insertOrder()
{
    createRequest(); 
    alert("otkuda");
    if(document.getElementById('idUser').value !== "")
    {
        alert("otkuda");
        var idUser = document.getElementById('idUser').value;
        var otkuda = document.getElementById('otkudaOrder').value;
        var kuda = document.getElementById('kudaOrder').value;
        var summ = document.getElementById('SUMMA').value;
        var km = document.getElementById('KM').value;
        
        alert(otkuda.value);
        var params = "{\"idUser\":\""+idUser+"\",\"otkuda\":\""+otkuda+"\",\"kuda\":\""+kuda+"\",\"summ\":\""+summ+"\",\"km\":\""+km+"\"}"; 
        var url = "http://localhost:8080/Restful5/webresources/rest.order1/create"; 
        request.open("POST", url, true); 
        request.setRequestHeader('Content-Type', 'application/json'); 
        request.send(params); 
        alert(otkuda);
        location.reload()
    }
    else
    {
        alert("kyda");
        var firstname = document.getElementById('firstnameOrder').value; 
        var lastname = document.getElementById('lastnameOrder').value; 
        var phone = document.getElementById('phoneOrder').value;
        var otkuda = document.getElementById('otkudaOrder').value;
        var kuda = document.getElementById('kudaOrder').value;
        var summ = document.getElementById('SUMMA').value;
        var km = document.getElementById('KM').value;
        
        alert(otkuda);
        var params = "{\"firstname\":\""+firstname+"\",\"lastname\":\""+lastname+"\",\"phone\":\""+phone+"\",\"otkuda\":\""+otkuda+"\",\"kuda\":\""+kuda+"\",\"summ\":\""+summ+"\",\"km\":\""+km+"\"}"; 
        var url = "http://localhost:8080/Restful5/webresources/rest.order1/createGuest"; 
        request.open("POST", url, true); 
         alert("aaaaa");
        request.setRequestHeader('Content-Type', 'application/json'); 
        request.send(params); 
        alert("aaaaa");
        location.reload()
    }	
}

function Auth()
{
	createRequest(); 
	var phone = document.getElementById('phoneAuth').value;
	var password1 = document.getElementById('passwordAuth').value; 	
	var params = "{\"phone\":\""+phone+"\",\"password\":\""+password1+"\"}"; 
	var url = "http://localhost:8080/Restful5/webresources/rest.user/auth"; 
	request.open("POST", url, true); 
	request.setRequestHeader('Content-Type', 'application/json'); 
	request.send(params); 
        location.reload()
}

function AuthExit()
{
	createRequest(); 
	var url = "http://localhost:8080/Restful5/webresources/rest.user/exit"; 
	request.open("POST", url, true); 
	request.setRequestHeader('Content-Type', 'application/json'); 
	request.send(null); 
        location.reload()
}

function handleResponseAuthEnd() 
{
    if (request.status==200)
    { 
        var det = eval("("+request.responseText+")");
        document.getElementById('idUser').value=det.id;
        document.getElementById('firstnameUser').value=det.firstname;
        document.getElementById('lastnameUser').value=det.lastname;
        document.getElementById('addressUser').value=det.address;
        document.getElementById('phoneUser').value=det.phone;
        document.getElementById('ordersUser').value=det.orders;
        document.getElementById('typeUser').value=det.type;
    }
}
var chet = 0;
function EnterTableOrders() 
{
    if (request.status==200)
    { 
        var json = request.responseText; 
        var json2 =""; 
        var arr = []; 
        var i; 
        var i2 = 0; 
        chet++;
        if (chet === 2)
        {
            $('#updateOrders').prop('disabled', true);
            return;
        }
        
        for(i=0; i<json.length;i++)
        { 
            json2 += json[i]; 
            if(json[i] == '}')
            { 
                arr[i2] = json2; 
                json2 = ""; 
                i2 ++; 
            } 
        } 
        var res=""; 
        checkboxCount = arr.length;
        for(i=0; i<arr.length;i++)
        { 
            var data = JSON.parse(arr[i]); 
            document.getElementById("lftable").insertRow(-1).innerHTML = '<tr><td><center><input type="checkbox" id="checkboxOrder'+i+'"/></center></td><td><center>'+data.id+'</center></td><td><center><b>'+data.date+'</b></center></td><td><center>'+data.startAddress+'</center></td><td><center>'+data.finishAddress+'</center></td><td><center><b>'+data.cost+'</b></center></td><td><center>'+data.way+'</center></td><td><center>'+data.id_user+'</center></td><td><center>'+data.id_car+'</center></td><td><center>'+data.order_info+'</center></td></tr>';
        }       
    }
}

function getAllOrders()
{
    createRequest(); 
    var url = "http://localhost:8080/Restful5/webresources/rest.order1/getOrders"; 
    request.onreadystatechange = EnterTableOrders;
    request.open("GET", url, true); 
    request.setRequestHeader('Content-Type', 'application/json'); 
    request.send(null); 
}

function EnterTableCars() 
{
    if (request.status==200)
    { 
        var json = request.responseText; 
        var json2 =""; 
        var arr = []; 
        var i; 
        var i2 = 0; 
        chetCar++;
        if (chetCar === 2)
        {
            //$('#updateCandidates').prop('disabled', true);
            return;
        }
        
        for(i=0; i<json.length;i++)
        { 
            json2 += json[i]; 
            if(json[i] == '}')
            { 
                arr[i2] = json2; 
                json2 = ""; 
                i2 ++; 
            } 
        } 
        var res=""; 
        for(i=0; i<arr.length;i++)
        { 
            var data = JSON.parse(arr[i]); 
            document.getElementById("carstable").insertRow(-1).innerHTML = '<tr><td><center><b>'+data.modelcar+'</b></center></td><td><center>'+data.placescar+'</center></td><td><center>'+data.colorcar+'</center></td></tr>';
        }       
    }
}

function EnterTableVacant() 
{
    if (request.status==200)
    { 
        var json = request.responseText; 
        var json2 =""; 
        var arr = []; 
        var i; 
        var i2 = 0; 
        chetVacant++;
        if (chetVacant === 2)
        {
            $('#updateCandidates').prop('disabled', true);
            return;
        }
        
        for(i=0; i<json.length;i++)
        { 
            json2 += json[i]; 
            if(json[i] == '}')
            { 
                arr[i2] = json2; 
                json2 = ""; 
                i2 ++; 
            } 
        } 
        var res=""; 
        checkboxCountVacant = arr.length;
        for(i=0; i<arr.length;i++)
        { 
            var data = JSON.parse(arr[i]); 
            document.getElementById("prtable").insertRow(-1).innerHTML = '<tr><td><center><input type="checkbox" id="checkboxVacant'+i+'"/></center></td><td><center>'+data.id+'</center></td><td><center><b>'+data.date+'</b></center></td><td><center>'+data.firstname+'</center></td><td><center>'+data.lastname+'</center></td><td><center>'+data.sex+'</center></td><td><center>'+data.modelcar+'</center></td><td><center>'+data.placescar+'</center></td><td><center>'+data.colorcar+'</center></td><td><center>'+data.contact+'</center></td></tr>';
        }       
    }
}

function getAllCandidates()
{
    createRequest(); 
    var url = "http://localhost:8080/Restful5/webresources/rest.vacant/getVacant"; 
    request.onreadystatechange = EnterTableVacant;
    request.open("GET", url, true); 
    request.setRequestHeader('Content-Type', 'application/json'); 
    request.send(null); 
}
