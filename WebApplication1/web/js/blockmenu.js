var i = [0,0,0,0,0,0,0,0];

function buttonPR()  
{
	if(i[0] == 0){
		allClose();
		$('#PR').css('left','50px');
		i[0] = 1;
	}
	else allClose();

}

function buttonAppl()  
{
	if(i[1] == 0){
		allClose();
		$('#Appl').css('left','50px');
		i[1] = 1;
	}
	else allClose();
}

function buttonCost()  
{
	if(i[2] == 0){
		allClose();
		$('#Cost').css('left','50px');
		i[2] = 1;
                
                if(document.getElementById('idUser').value !== "")
                {
                    $('#firstnameOrder').prop('disabled', true);
                    $('#lastnameOrder').prop('disabled', true);
                    $('#phoneOrder').prop('disabled', true);
                    $('#otkudaOrder').prop('disabled', true);
                    $('#kudaOrder').prop('disabled', true);
                    $('#SUMMA').prop('disabled', true);
                    $('#KM').prop('disabled', true);
                    document.getElementById('firstnameOrder').value = document.getElementById('firstnameUser').value;
                    document.getElementById('lastnameOrder').value = document.getElementById('lastnameUser').value;
                    document.getElementById('phoneOrder').value = document.getElementById('phoneUser').value;
                }
                else
                {
                    $('#otkudaOrder').prop('disabled', true);
                    $('#kudaOrder').prop('disabled', true);
                    $('#SUMMA').prop('disabled', true);
                    $('#KM').prop('disabled', true);
                }
	}
	else allClose();
}

function buttonMoney()  
{
	if(i[3] == 0){
		allClose();
		$('#Money').css('left','50px');
		i[3] = 1;
	}
	else allClose();
}

function buttonLike()  
{
	if(i[4] == 0 && document.getElementById('typeUser').value == "1"){
		allClose();
		$('#Like').css('left','50px');
                $('#Like').css('width','70%');
		i[4] = 1;
	}
        else if(i[4] == 0 && (document.getElementById('typeUser').value == "0" || document.getElementById('typeUser').value == ""))
        {
            alert("Вход ограничен!")
        }
	else 
        {
            allClose();
            $('#Like').css('width','0');
        }
}

function buttonCont()  
{
	if(i[5] == 0){
		allClose();
		$('#Cont').css('left','50px');
		i[5] = 1;

	}
	else allClose();
}

function buttonVacant()  
{
	if(i[6] == 0){
		allClose();
		$('#Vacant').css('left','50px');
		i[6] = 1;
	}
	else allClose();
}

function buttonPark()  
{
	if(i[7] == 0){
		allClose();
		$('#Park').css('left','50px');
		i[7] = 1;
	}
	else allClose();
}

function allClose(){
	i = [0,0,0,0,0,0,0,0];
	$('#PR').css('left','-1000px');
	$('#Appl').css('left','-1000px');
	$('#Cost').css('left','-1000px');
	$('#Money').css('left','-1000px');
	$('#Like').css('left','-1000px');
	$('#Cont').css('left','-1000px');
	$('#Vacant').css('left','-1000px');
	$('#Park').css('left','-1000px');
}