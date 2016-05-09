<%-- 
    Document   : newjsp
    Created on : 07.05.2016, 8:22:30
    Author     : Sizon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title> Taxi </title>
	<meta http-equiv ="content-type" content="text/html; charset = utf-8" />
	<link rel= "stylesheet" type = "text/css" href = "style/style.css"  />
	<link rel= "stylesheet" type = "text/css" href = "style/styleblockmenu.css"  />
	<script src="js/jquery.js"></script>
	<script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
    <script src="js/DeliveryCalculatorClass.js" type="text/javascript"></script>
	<script src="js/blockmenu.js" type="text/javascript"></script>
    <script src="js/deliveryCalculator.js" type="text/javascript"></script>
	<script src="js/getMessage.js" type="text/javascript"></script>
	
	<script>
            var statCars = 0;
            function getCars()
            {
                if(statCars == 1)
                    return;
                createRequest(); 
                var url = "http://localhost:8080/Restful5/webresources/rest.car/getCars"; 
                request.onreadystatechange = EnterTableCars;
                request.open("GET", url, true); 
                request.setRequestHeader('Content-Type', 'application/json'); 
                request.send(null); 
                statCars++;
            }
         function getAuth()
        {  
            createRequest(); 
            var url = "http://localhost:8080/Restful5/webresources/rest.user/getSession"; 
            request.onreadystatechange = handleResponseAuthEnd;
            request.open("GET", url, true);
            request.send(null);
            
        }
        
        window.onload = getAuth();
         
        
	</script>
		 
</head>
<body>

<div id="PR" style="background-color: #4876FF;">
	<center>
		<b>Авторизация</b><br><br>
		<table style="margin-left: 20px">
			<tr>
				<td>
					Телефон:
				</td>
				<td>
					<input type="text" name="phoneAuth" id="phoneAuth" size="8" required/>
				</td>
			</tr>
			<tr>
				<td>
					Пароль:
				</td>
				<td>
					<input type="text" name="passwordAuth" id="passwordAuth" size="8" required/>
				</td>
			</tr>
                        <tr>
				<td>
					<button onclick="Auth()"><img src="images/home.png" width="20%" alt="AuthEnterLogo" 
                                        style="vertical-align: middle"> Войти
                                        </button>
				</td>
				<td>
					<button style="background-color: lightsteelblue; width: 90px" onclick="AuthExit()"> Выйти
                                        </button>
				</td>
			</tr>
		</table><br>
		
                
		<br><br>
			<b>Регистрация</b><br><br>
			<table>
				<tr>
					<td>
						Имя:
					</td>
					<td>
						<input type="text" name="firstnameReg" id="firstnameReg" size="8" required/>
					</td>
				</tr>
				<tr>
					<td>
						Фамилия:
					</td>
					<td>
						<input type="text" name="lastnameReg" id="lastnameReg" size="8" required/>
					</td>
				</tr>
				<tr>
					<td>
						Адрес:
					</td>
					<td>
						<input type="text" name="addressReg" id="addressReg" size="8" required/>
					</td>
				</tr>
				<tr>
					<td>
						Телефон:
					</td>
					<td>
						<input type="text" name="phoneReg" id="phoneReg" size="8" required/>
					</td>
				</tr>
				<tr>
					<td>
						Пароль:
					</td>
					<td>
						<input type="text" name="passwordReg" id="passwordReg" size="8" required/>
					</td>
				</tr>
			</table><br>
			<button onclick="Registration()"><img src="images/computer.png" width="10%" alt="RegEnterLogo" 
			style="vertical-align: middle"> Регистрация
			</button>
	</center> 
</div>
<div id="Appl" style="background-color: #DEB887; padding-left: 4%">
    <center>
        <font style="color: brown"><b>Кандидаты требуются трудолюбивые, вежливые, с хорошим чувством юмора.<br>Оплата по итогу собеседования!</b><br><br>
        <b>Отправить вакансию:</b><br><br></font>
    <table>
            <tr>
                    <td>
                            Имя:
                    </td>
                    <td>
                            <input type="text" id="firstnameVacancy" size="12" required/>
                    </td>
            </tr>
             <tr>
                    <td>
                            Фамилия:
                    </td>
                    <td>
                            <input type="text" id="lastnameVacancy" size="12" required/>
                    </td>
            </tr>
            <tr>
                    <td>
                            Пол:
                    </td>
                    <td>
                            <input type="text" id="sexVacancy" size="12" required/>
                    </td>
            </tr>
            <tr>
                    <td>
                            Автомобиль (модель, год):
                    </td>
                    <td>
                            <input type="text" id="modelcarVacancy" size="12" required/>
                    </td>
            </tr>
            <tr>
                    <td>
                            Количество мест:
                    </td>
                    <td>
                            <input type="text" id="placescarVacancy" size="12" required/>
                    </td>                                
            </tr>
            <tr>
                    <td>
                            Цвет автомобиля:
                    </td>
                    <td>
                            <input type="text" id="colorcarVacancy" size="12" required/>
                    </td>
            </tr>
            <tr>
                    <td>
                            Контактные данные:
                    </td>
                    <td>
                            <input type="text" id="contactVacancy" size="12" required/>
                    </td>
            </tr>
    </table><br>
    <button onclick="insertVacancy()"><img src="images/favourite.png" width="10%" alt="VacancyInsert" 
    style="vertical-align: middle"> Рискнуть!
    </button>
</center>
</div>
<div id="Cost" style="background-color: #3CB371; padding-left: 4%">
<center>
    <b>Оформление заказа</b><br><br>
    <table>
            <tr>
                    <td>
                            Имя:
                    </td>
                    <td>
                            <input type="text" id="firstnameOrder" size="12" required/>
                    </td>
            </tr>
             <tr>
                    <td>
                            Фамилия:
                    </td>
                    <td>
                            <input type="text" id="lastnameOrder" size="12" required/>
                    </td>
            </tr>
            <tr>
                    <td>
                            Телефон:
                    </td>
                    <td>
                            <input type="text" id="phoneOrder" size="12" required/>
                    </td>
            </tr>
            <tr>
                    <td>
                            Откуда:
                    </td>
                    <td>
                            <input type="text" name="otkydaOrder" id="otkudaOrder" size="12" required/>
                    </td>
            </tr>
            <tr>
                    <td>
                            Куда:
                    </td>
                    <td>
                            <input type="text" name="kudaOrder" id="kudaOrder" size="12" required/>
                    </td>                                
            </tr>
            <tr>
                    <td>
                            Стоимость:
                    </td>
                    <td>
                            <input type="text" name="priceOrder" id="SUMMA" size="12" required/>
                    </td>
            </tr>
            <tr>
                    <td>
                            Расстояние:
                    </td>
                    <td>
                            <input type="text" name="priceOrder" id="KM" size="12" required/>
                    </td>
            </tr>
            
    </table>
    <br><center><b>Тариф: 5900/км</b></center><br>
    <button onclick="insertOrder()"><img src="images/cart-alt-4.png" width="10%" alt="AuthEnterLogo" 
    style="vertical-align: middle"> Оформить заказ
    </button>
</center>
</div>
<div id="Money" style="background-color: #FF7F00">
<center>
    <b>Рассчет стоимости</b><br><br>
    <table>
            <tr>
                    <td>
                            Расстояние:
                    </td>
                    <td>
                            <input type="text" name="phoneAuth" id="KM" size="8" disabled required/>
                    </td>
            </tr>
            <tr>
                    <td>
                            Сумма:
                    </td>
                    <td>
                            <input type="text" name="passwordAuth" id="SUMMA" size="8" disabled required/>
                    </td>
            </tr>
    </table><br>
 </div>
    
    
<div id="Like">
    
    <center>
        <font style="color: brown"><b>Просмотр заказов:</b><br><br></font>

        <table class="tftable" border="1" id="lftable">
        <tr><th>Принять</th><th>ИД</th><th>Дата</th><th>Откуда</th><th>Куда</th><th>Цена</th><th>Расстояние</th><th>ИД Клиента</th><th>ИД Авто</th><th>Инфо</th></tr>
        </table>
           
        <br><button id="updateOrders" onclick="getAllOrders()"><img src="images/computer.png" width="20%" alt="getOrders" 
        style="vertical-align: middle"> Обновить
        </button>
        <button id="acceptOrders" onclick="acceptOrders()"><img src="images/computer.png" width="20%" alt="acceptOrders" 
        style="vertical-align: middle"> Принять
        </button>
    </center>
    
    <center>
        <br><font style="color: darkolivegreen"><b>Просмотр кандидатов:</b><br><br></font>

        <table class="tftable" border="1" id="prtable">
        <tr><th>Принять</th><th>ИД</th><th>Дата подачи</th><th>Имя</th><th>Фамилия</th><th>Пол</th><th>Модель(авто)</th><th>Кол-во мест(авто)</th><th>Цвет</th><th>Контактные данные</th></tr>
        </table>
           
        <br><button id="updateCandidates" onclick="getAllCandidates()"><img src="images/computer.png" width="20%" alt="getOrders" 
        style="vertical-align: middle"> Обновить
        </button>
        <button id="acceptCandidate" onclick="acceptCandidates()"><img src="images/computer.png" width="20%" alt="acceptOrders" 
        style="vertical-align: middle"> Принять
        </button>
    </center>
    
</div>
    
    
    
<div id="Cont" style="padding-left: 5%; background-color: moccasin"> 
    <center>
        <b>О компании</b><br><br>
«TAXI» - имеет многолетний опыт работы и стремится к тому, чтобы обслуживание клиентов проходило на высоком уровне. Мы уважительно относимся к заказчикам, поэтому предлагаем им только качественные услуги. Клиентам нравится такой подход, поэтому они обращаются к нам снова.
<br><br>
<b>Мы будем прислушиваться к Вашему мнению и надеемся, что Вы всегда будете с нами.</b>
<br><br>
<img src="images/yellow-cab-mercedesf.png" width="100%"/>
<img src="images/taxi_car.png" width="100%"/>
    </center>
</div>
<div id="Vacant">
    <center>
        <b>Информация о пользователе</b><br><br>
        <table>
                <tr>
                        <td>
                                ID User
                        </td>
                        <td>
                                <input type="text" id="idUser" size="8" disabled required/>
                        </td>
                </tr>
                <tr>
                        <td>
                                Имя:
                        </td>
                        <td>
                                <input type="text" id="firstnameUser" size="8" disabled required/>
                        </td>
                </tr>
                <tr>
                        <td>
                                Фамилия
                        </td>
                        <td>
                                <input type="text" id="lastnameUser" size="8" disabled required/>
                        </td>
                </tr>
                <tr>
                        <td>
                                Адрес
                        </td>
                        <td>
                                <input type="text" id="addressUser" size="8" disabled required/>
                        </td>
                </tr>
                <tr>
                        <td>
                                Телефон
                        </td>
                        <td>
                                <input type="text" id="phoneUser" size="8" disabled required/>
                        </td>
                </tr>
                <tr>
                        <td>
                                Кол. заказов
                        </td>
                        <td>
                                <input type="text" id="ordersUser" size="8" disabled required/>
                        </td>
                </tr>
                <tr>
                        <td>
                                Гость
                        </td>
                        <td>
                                <input type="text" id="typeUser" size="8" disabled required/>
                        </td>
                </tr>
	</table><br>
    </center>
</div>
<div id="Park" style="padding-left: 5%; background-color: #B5B5B5">

    <center>
        <b>Автопарк</b><br><br>
   Автомобильный парк «TAXI» укомплектован комфортабельными и современными машинами, которые находятся в отличном состоянии, имеют презентабельный вид и соответствуют всем современным стандартам.
   <br><br>
<b>Каждый автомобиль оснащен таксометром, что исключает обман со стороны водителя. Вы четко платите по тому чеку, который выпишет таксометр. Это очень удобно и для компаний, оплачивающих наши услуги для своих сотрудников - теперь бухгалтерская отчетность сводится к минимуму.    
</b><br><br>
    <div style="overflow-y: scroll; height: 200px;">
        <table class="tftable" border="1" id="carstable" style="height: 200px;">
            <tr><th>Модель</th><th>Количество дверей</th><th>Цвет</th></tr>
        </table>
    </div>
   <br>
   <img src="images/yellow-cab-mercedesf.png" width="80%"/>
       </center>

</div>

<div style="z-index: 0; width: 6%; height: 52%; position: absolute; left: 4px; top: 390px; background-color: white; opacity: 0.8">

</div>

<div id="map" style="width: 100%; height: 91%; position: absolute; right: 0; top: 0px; left: 0.40%; z-index:1;"></div>

</div>
<div id="menu" >
<br>
<div class="btn-Logo"></div><br>
<div class="button btn-PR" id="btn-PR" onclick="buttonPR()"></div><br>
<div class="button btn-Appl" id="btn-Appl" onclick="buttonAppl()"></div><br>
<div class="button btn-Cost" id="btn-Cost" onclick="buttonCost()"></div><br>
<div class="button btn-Money" id="btn-Money" onclick="buttonMoney()"></div><br>
<div class="button btn-Like" id="btn-Like" onclick="buttonLike()"></div><br>
<div class="button btn-Cont" id="btn-Cont" onclick="buttonCont()"></div><br>
<div class="button btn-Vacant" id="btn-Vacant" onclick="buttonVacant()"></div><br>
<div class="button btn-Park" id="btn-Park" onclick="buttonPark(); getCars()"></div><br>
<br>
</div>
<div id= "footer">
<div id= "contacts">
</div>
</div>
<center>Copyright Алёшки (с)</center>
 </body>
</html>
