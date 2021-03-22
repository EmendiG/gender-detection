Gender detection project:<br><br>
1) Endpoint /gender :
- responsible for gender detection based on passed full name separated by anything that is not an alphabet letter and passed algorithm [list / first]
- **list** algorithm takes into consideration all defined names
- **first** algorithm takes only first name under consideration when determining gender
- /gender?algorithm=**[algorithm]**&name=**[full name]**
<br>
2) Endpoint /tokens :
- responsible for returning all available tokens for picked gender **[male / female]**
- /tokens&gender=**[gender]**
<br><br><br>
Docker cmd (**jar** file required):
1. docker-compose build
2. docker run -p [port]:8080 gender-detection