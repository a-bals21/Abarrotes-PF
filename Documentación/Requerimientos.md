# Requerimientos

## Requerimientos de Usuarios

1. Presentar información de ayuda perteneciente al proyecto InfoUADY.

2. El proyecto cuenta con facilidad de acceso para los universitarios.

3. La información proviene de fuentes confiables por medio de profesionales, documentos oficiales/verificados.

4. La información tendrá un formato técnico/coloquial para una comprensión sencilla.

## Requerimientos Funcionales

| RF0001 | Registro de usuario |
|--------| ------ | 
|Descripción | El sistema pedirá los datos correspondientes para registrar un nuevo usuario dentro del software y este se almacenará utilizando como persistencia de datos en el gestor SQLite donde se almacenará la información de los usuarios. |
| Prioridad | Alta |
| Entradas  |• Nombre
             • Apellido Paterno
             • Correo Electrónico
             • Contraseña
             • Calle
             • Número
             • Colonia
             • Código Postal
             • Estado
             • Ciudad
             • Teléfono |
| Salidas   |• Mensaje de error en el caso de no haber llenado algún campo.
             • Mensaje de error en caso de ingresar incorrectamente los datos, es decir que el formato de los datos sea incorrecto.
             • Mensaje que despliegue una ventana de registro exitoso en caso de haber rellenado todos los campos de manera correcta.|
| Información Adicional | • El sistema debe proporcionar un ID al usuario para su registro que será almacenado junto a la hoja de información del software.
                          • El usuario al registrarse será redirigido al log-in del sistema, es decir, a la interfaz de cliente.|