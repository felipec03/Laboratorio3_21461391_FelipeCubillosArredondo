# Laboratorio 3: Paradigmas de Programación
## Instrucciones de uso:
- Tener instalado Gradle (fué utilizado Gradle 8.5)
- Tener instalado y configurado Java 11 con SDK Amazon Coretto 11
- Tener configurada las variables de entorno dependiendo del Sistema Operativo
### En Windows
*Windows 10 fué utilizado para probar el laboratorio localmente en un Acer Nitro 5 AN515-42*

En el siguiente directorio:
```"Laboratorio3_21461391_FelipeCubillosArredondo-main"```
Abrir una terminal y poner los siguientes comandos:

```shell
gradlew.bat build
gradlew.bat run
```
En caso de no funcionar, revisar que se está utilizando la versión correcta de Java y que las variables de entorno están correctamente configuradas.

### En Linux
*Debian 12 fué utilizado para probar el laboratorio localmente en un Lenovo Thinkpad L470*
En el siguiente directorio:
```"Laboratorio3_21461391_FelipeCubillosArredondo-main"```
Abrir una terminal y poner los siguientes comandos:
```shell
./gradlew build
./gradlew run
```
Puede ocurrir que de el siguiente error:
```bash
ERROR: JAVA_HOME is set to an invalid directory: /usr/lib/jvm/open-jdk

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation.
```
En ese caso, indica que la variable de entorno, JAVA_HOME no está bien configurada, por lo que debemos buscar el directorio que corresponde a nuestra instalación de Java
```
readlink -f $(which java)
```
**El resultado de este comando se debe poner en la siguiente línea de código, en el espacio de path, incluídos paréntesis.**
```
export JAVA_HOME="path"
```

Luego, habría que repetir la secuencia de build y run.