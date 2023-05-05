# Requerimientos

## Requerimientos Funcionales

| RF0001 | Registro de usuario |
|--------| ------ | 
| Descripción | El sistema pedirá los datos correspondientes para registrar un nuevo usuario dentro del software y este se almacenará utilizando como persistencia de datos en el gestor SQLite donde se almacenará la información de los usuarios. |
| Prioridad | Alta |
| Entradas  | - Nombre(s), apellidos, correo electrónico, contraseña, calle, número, colonia, código postal, estado, ciudad, número de teléfono. |
| Salidas   | - Mensaje de error en el caso de no haber llenado algún campo. |
|           | - Mensaje de error en caso de ingresar incorrectamente los datos, es decir que el formato de los datos sea incorrecto. |
|           | - Mensaje que despliegue una ventana de registro exitoso en caso de haber rellenado todos los campos de manera correcta. |
| Información Adicional   | El sistema debe proporcionar un ID al usuario para su registro que será almacenado junto a la hoja de información del software. |
|                         | El usuario, al registrarse, será redirigido al log-in del sistema, es decir, a la interfaz de cliente. |




