var menuObject = 0;
 var PR = 0;
  
function buttonPR()
{
  if(PR == 0)
  {
	  $('#menu').css('width','400');
	  $('#menu').css('opacity','0.8');
	  //$('#menu').css('background-color','gray');
	  PR = 1;
  }
  else
  {
	  $('#menu').css('width','100');
	  $('#menu').css('opacity','1');
	  PR = 0;
  }
};