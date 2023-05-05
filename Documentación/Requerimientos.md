# Requerimientos

## Requerimientos Funcionales

| RF001 | Registro de usuario |
|--------| ------ | 
| Descripción | El sistema pedirá los datos correspondientes para registrar un nuevo usuario dentro del software y este se almacenará utilizando como persistencia de datos en el gestor SQLite donde se almacenará la información de los usuarios. |
| Prioridad | Alta |
| Entradas  | - Nombre(s), apellidos, correo electrónico, contraseña, calle, número, colonia, código postal, estado, ciudad, número de teléfono. |
| Salidas   | - Mensaje de error en el caso de no haber llenado algún campo. |
|           | - Mensaje de error en caso de ingresar incorrectamente los datos, es decir que el formato de los datos sea incorrecto. |
|           | - Mensaje que despliegue una ventana de registro exitoso en caso de haber rellenado todos los campos de manera correcta. |
| Información Adicional   | El sistema debe proporcionar un ID al usuario para su registro que será almacenado junto a la hoja de información del software. |
|                         | El usuario, al registrarse, será redirigido al log-in del sistema, es decir, a la interfaz de cliente. |



| RF002 | Log-in de usuario |
|--------| ------ | 
| Descripción | El sistema pedirá los datos de entrada necesarios para realizar el inicio de sesión dentro del software, dicha información será validada desde el gestor de datos. |
| Prioridad | Alta |
| Entradas  | - Correo electrónico |
|           | - Contraseña.
| Salidas   | - Mensaje de error en el caso de no haber llenado algún campo. |
|           | - Mensaje de error en caso de ingresar incorrectamente los datos, es decir, que el formato de los datos sea incorrecto. |
|           | - Mensaje que despliegue una ventana de registro exitoso en caso de haber rellenado todos los campos de manera correcta. |
| Información Adicional   | El sistema debe proporcionar un ID al usuario para su registro que será almacenado junto a la hoja de información del software. |
|                         | El usuario al registrarse será redirigido al log-in del sistema, es decir, a la interfaz de cliente. |



| RF003 | Registro de artículos. |
|--------| ------ | 
| Descripción | El sistema pedirá los datos correspondientes para registrar un nuevo artículo dentro del software y este se almacenará utilizando como persistencia de datos en el gestor SQLite donde se almacenará la información de los artículos. |
| Prioridad | Alta |
| Entradas  | - ID, nombre del artículo, precio al público, precio del proveedor, total en existencia. |
| Salidas   | - Mensaje de error en el caso de no haber llenado algún campo. |
|           | - Mensaje de error en caso caso de ingresar incorrectamente los datos, es decir, que el formato de los datos sea incorrecto. |
|           | - Mensaje que despliegue una ventana de registro exitoso en caso de haber rellenado todos los campos de manera correcta. |
| Información Adicional   |   |



| RF004 | Realizar compra. |
|--------| ------ | 
| Descripción | El sistema permitirá que el usuario pueda seleccionar los artículos que decida comprar y almacenarlos en un carrito de compras siempre y cuando estos se encuentren con disponibilidad en stock. |
| Prioridad | Alta |
| Entradas  | - Artículos por seleccionar. |
| Salidas   | - Precio unitario de los artículos. |
|           | - Sumatoria del precio unitario. |
|           | - Importe por pagar (incluyendo el IVA). |
| Información Adicional   | El número de artículos en stock debe ser visible al usuario, en caso de sobrepasar el límite se deberá desplegar un mensaje de advertencia. |



| RF005 | Ticket de compra. |
|--------| ------ | 
| Descripción | El sistema permitirá desplegar al usuario un ticket donde se encuentre la información de compra que realizó. |
| Prioridad | Alta |
| Entradas  |  |
| Salidas   | - Nombre de la tienda. |
|           | - Dirección de la tienda. |
|           | - Número de ticket. |
|           | - Fecha de la compra. |
|           | - Nombre del cliente. |
|           | - Precio unitario de los artículos. |
|           | - Precio total de los artículos. |
|           | - Importe por pagar (incluyendo el IVA. |
| Información Adicional   | De preferencia este archivo deberá guardarse con extensión .pdf. |






