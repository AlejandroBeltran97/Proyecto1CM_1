# Proyecto 1 (Cómputo Móvil)

## Obtención de datos relativos a la fecha de nacimiento y nombre del usuario.

### Vista General del Problema

El proyecto consiste en el desarrollo de una aplicación para dispositivos Android (mediante **Android Studio**), en la cual como pantalla principal se deberán mostrar los campos a llenar, que son:

   - **Nombre(s)**.
   
En este campo el usuario deberá ingresar su nombre o nombres, según sea el caso. Como es de esperarse, el nombre no debe contener caracteres diferentes a los incluídos en el alfabeto.
   
   - **Apellidos**
   
Este campo debe contener los apellidos del usuario que esté utilizando la aplicación. Dados los fines que se explicarán posteriormente, es requisito indispensable que el usuario ingrese tanto el apellido paterno como el materno. Para ello, se debe condicionar el campo a que ingrese una cadena de texto tal que exista un espacio, es decir, dos palabras.

   - **Fecha de Nacimiento**
   
La fecha de nacimiento, como su nombre lo indica, corresponde al día, mes y año en que el usuario nació.

Posterior a que se inicialice esta ventana o pantalla, debe existir la posibilidad de presionar un botón que permita obtener los siguientes datos:

   - **Signo Zodiacal**
   
El signo zodiacal estará basado en las fechas oficiales que corresponden a los 12 signos, contemplando el día y el mes de nacimiento de la persona. 

   - **RFC**
   
Se mostrará el RFC del usuario, acorde a los siguientes parámetros:

      - Primeras dos letras del apellido paterno.
      - Primera letra del apellido materno.
      - Primera letra del nombre.
      - Fecha de nacimiento, en el formato **yy/mm/dd**. 
      
Como se mencionó previamente, es de vital importancia que el usuario ingrese ambos apellidos en el campo correspondiente, para que el cálculo del RFC sea posible. 

   - **Animal Acorde al Calendario Chino**
   
Se deberá mostrar el animal asociado a la fecha en la que nació la persona.

   - **Edad Cumplida**
   
Otro de los datos que se mostrarán como resultado, es la edad cumplida del usuario; es decir, desde la fecha de nacimiento a la actual, contemplando si en el año actual ya pasó el cumpleaños o aún no.

### Propuesta de Solución

### Pantalla Principal (MainActivity)

Como propuesta de solución, se tiene la intención de generar una nueva pantalla en donde se puedan visualizar los datos requeridos, mismos que fueron calculados con base en el nombre, apellidos y fecha de nacimiento. 

Antes de ello, se generó una primera pantalla en donde aparecen los campos que el usuario debe ingresar. En ella aparece el título de la aplicación y tres cajas de texto:

   - En las dos primeras, es posible tener una inserción directa de texto, para que el propio usuario pueda ingresar su nombre y apellidos, atendiendo a las condiciones que fueron descritas en la **Vista General del Problema**.
   - En la tercera, al pulsar sobre ella se desplegará un calendario. En la esquina superior izquierda, se puede pulsar sobre el año para que el usuario seleccione en cuál nació. Al hacerlo, se despliegan los meses y días correspondientes al año seleccionado, por lo que restará que pulse sobre su día de nacimiento. Para desplazarse por los meses, en las esquinas superiores izquierda y derecha del calendario hay flechas que permiten hacer un barrido por los meses.
   
Finalmente, en la sección central inferior de la pantalla hay un botón que permite enviar la información necesaria hacia la siguiente pantalla, que es en donde se calcularán los parámetros requeridos.

### Pantalla de Resultados (ResultActivity)

En la generación de la pantalla de resultados (denominada **ResultActivity**), se muestra en la parte central superior una figura que, aunque no está en los requisitos, se añadió por estética. Es una figura asociada al signo zodiacal azteca; son 13 animales diferentes, asociados a diferentes fechas. Debajo de esa imagen, es colocado un saludo hacia la persona o usuario que está empleando la aplicación. 

Pasando a la sección inferior de la pantalla, se muestran 4 tarjetas, posicionadas en forma de tabla. En cada una de ellas se muestra un dato a calcular:

   - **Signo Zodiacal (Superior izquierda)**
   
Para el calculo del signo zodiacal se contempló principalmente el mes y día de nacimiento, y con base en ello se proporciona un ícono que corresponde al mismo. Adicionalmente, debajo del ícono es mostrado en texto el signo zodiacal.

   - **RFC (Superior derecha)**
   
Calculando el RFC acorde a los lineamientos descritos, se despliega en otra de las tarjetas, utilizando únicamente la inserción de texto dentro de la misma, pero con otro color. Debajo de él, está indicado que se trata del RFC.

   - **Animal Acorde al Calendario Chino (Inferior izquierda)**
   
Para la determinación del animal, se contempló únicamente el año en el que nació la persona, haciendo una comparación con los años que corresponden a cada uno de los animales. Al tener uno determinado, en otra tarjeta se despliega la imagen que corresponde al animal, y debajo de ella se indica el nombre del mismo.

   - **Edad (Inferior derecha)**
   
Para el cálculo de la edad, se realizó primero una resta matemática entre el año actual y el año de nacimiento del usuario. Posteriormente se hizo la verificación de si el día de cumpleaños ya había pasado o aún no; en caso negativo, al resultado de la resta se le disminuye en una unidad. Finalmente se despliega como una entrada de texto en la última de las tarjetas, teniendo debajo de esa inserción que ese campo corresponde a la edad. 
