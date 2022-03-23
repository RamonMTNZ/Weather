¿Qué has empezado implementando y por qué?
He empezado implementando los tests. Al hacer los tests primero te obliga revisar el código y estar seguro de que lo entiendas. Lo cual ayuda a la hora de detectar posibles problemas. Además te da una base mas sólida que no hacerlo a la hora de empezar a refactorizar.

¿Qué problemas te has encontrado al implementar los tests y cómo los has solventado?
Lo que mas problemas me ha dado son las fechas, los formatos son algo confusos a simple vista, y sin usar el depurador hubiera sido imposible obtener toda la información, como por ejemplo que la página solo devuelve el clima de los últimos 6 días. 

¿Qué componentes has creado y por qué?
He creado varias funciones privadas por distintos motivos. Algunas líneas de código se repiten, por lo que ponerlas en su propia función ayuda a restar complejidad y puede ayudar en el futuro en el caso de que se tenga que repetir esa operación otra vez. Otras son muy largas y pueden resultar confusas
por lo que ponerlas en su propia función ayuda mucho a la legibilidad del código. Finalmente, he metido varios tests booleanos en su propia función, ya que eran muy largos y esto ha hecho el código del API público mucho mas compacto y legible. 

¿Has utilizado  streams, lambdas y optionals de Java 8? ¿Qué te parece la programación funcional?
No, soy bastante contrario a los lambdas, especialmente en un caso como este en el que el objetivo es refactorizar para mejorar la mantenibilidad. Los lambdas pueden resultar mas difíciles de entender que otras alternativas.

¿Qué piensas del rendimiento de la aplicación? 
Puede ser aceptable dependiendo del contexto. Tarda algo más de un segundo por cada HttpRequest, lo cual en una aplicación pequeña en la que un usuario quiera ver el tiempo de una sola ciudad puede valer. Pero cualquier escala mayor requeriría otro enfoque. 

¿Qué harías para mejorar el rendimiento si esta aplicación fuera a recibir al menos 100 peticiones por segundo?
Como este código siempre devuelve la misma información para cada ciudad, independientemente de la fecha dada, una posible solución sería almacenar diariamente el array resultante de cada búsqueda, de tal manera que si algún usuario vuelve a buscar una ciudad que ya ha sido buscada hoy, no sea necesario
el HttpRequest, sino buscar en un array. 

¿Cuánto tiempo has invertido para implementar la solución? 
80 Minutos aproximadamente analizando la aplicación y escribiendo tests.
40 Minutos diseñando las posibles mejoras.
60 Minutos implementando dichas mejoras.
15 Minutos ejecutando los tests y arreglando un pequeño fallo.

Sin contar descansos.

¿Crees que en un escenario real valdría la pena dedicar tiempo a realizar esta refactorización?
Si, siempre. El código se lee mas veces de las que se escribe, por ello debe ser fácil de leer. Por lo que cualquier tiempo invertido en este tipo de actividad siempre es necesario. Aunque lo ideal sería asegurarse de producir código legible que no necesite este tipo de refactorización. 
