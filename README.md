# ConexaApp

Saludos a quien corresponda.
En primer lugar, agradecer por el tiempo que se tomarán para analizar este código y por la oportunidad.
En segundo lugar una disculpa, este test técnico se realizó en aproximadamente 6hs netas, con lo cuál he utilizado por ejemplo la creación por parte del IDE de fragments + viewmodel, o del fragment con maps, para ahorrar tiempo. Soy una persona prágmatica dicho sea de paso. Si el tiempo apremia buscaré una solución que satisfaga.

Finalmente, respecto al test en sí, decir que la UI no esta cuidada simplemente quise hacer incapie en el uso de funciones lambda, que suelo usarlas a menudo pues me parece mejor que las interfaces (tambien las funciones de extension aunque en este test no hubo lugar para sumarlas). Por otra parte quise tener bien separada la arquitectura, para respetar lo maximo posible el principio de responsabilidad unica (tomandome atribuciones, como por ejemplo el ViewHolder dentro del mismo Adapter, pero el mini proyecto no ameritaba mas). Tambien hubiese utilizado dagger hilt 2 para inyeccion de dependencias. No esta utilizado por falta de tiempo, lo mismo sucede con el objeto retrofit, lo tengo instanciado 3 veces, no tiene sentido, eso deberia ser un singleton al menos pero lamentablemente no hubo mucho tiempo...

Con esto quiero decir que he hecho la app como un MVP (minimo viable producto) para el test tecnico, podria defender el proyecto indicando mis propios errores y como solucionarlos, quizas lo podamos ver en el entrevista tecnica oral.

Solo inclui un unit test, podria haber testeado el otro caso de uso pero es muy similar y no le veia el punto.

Muchas gracias y saludos cordiales.
