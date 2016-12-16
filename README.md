# Mercado de Abasto
### Ejercicio 4 de los módulos Programación Orientada a Objetos y Bases de Datos

> Este ejercicio forma parte de la Guía Práctica de los módulos Programación Orientada a Objetos y Bases de Datos
> del Programa Nacional [111mil Programadores](https://www.argentina.gob.ar/111mil).

 * El Mercado de Abasto de Frutas y Verduras de una ciudad de la región necesita un Sistema de Información que brinde soporte a las actividades que allí se realizan.
 * El mercado está organizado en sectores. Cada sector contiene puestos, los cuales son alquilados a empresas y quinteros (genéricamente clientes) para que allí realicen sus ventas. Existen distintos tipos de puestos (con techo, sin techo, con cámara refrigerante, etc.) y distintas dimensiones para cada puesto (10m2, 15m2, etc.), para poder ajustarse mejor a las necesidades de cada cliente.
 * El precio del alquiler depende del sector en el que se encuentre el puesto, el tipo de puesto y sus dimensiones, y está predefinido.
 * Cuando un cliente desea alquilar uno o más puestos, se verifica la disponibilidad del tipo de puesto que requiere. Si existe disponibilidad y el cliente está de acuerdo con el precio, se realiza un contrato de alquiler por cada puesto que se alquile. En el contrato se especifica la fecha de inicio y fin del alquiler, el monto mensual del alquiler y tiene además un número que identifica el contrato que es único y el nombre del responsable por parte del Mercado que intervino en la firma del contrato y el responsable de la registración del mismo. Además, cada puesto cuenta con un medidor para el consumo de energía eléctrica.
 * Mensualmente se registran las lecturas de cada medidor, ya que el consumo de cada puesto es facturado al cliente que está alquilando ese puesto. En el momento de efectuar el alquiler, se registra en el contrato la última lectura del medidor del puesto que se está alquilando. Los aspectos vinculados a la facturación quedan excluidos del alcance del sistema, como así también la gestión de cobro de los alquileres.
