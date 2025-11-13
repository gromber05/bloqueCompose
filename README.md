# Práctica Estados - Gonzalo Romero Bernal

---

## Índice

1.  [Creación del proyecto](#creación-del-proyecto)
2.  [Ejercicio 1 — Text](#ejercicio-1--text)
3.  [Ejercicio 2 — TextField](#ejercicio-2--textfield)
4.  [Ejercicio 3 — Button](#ejercicio-3--button)
5.  [Ejercicio 4 — Image](#ejercicio-4--image)
6.  [Ejercicio 5 — Progress](#ejercicio-5--progress)
7.  [Ejercicio 6 — Switch](#ejercicio-6--switch)
8.  [Ejercicio 7 — Checkbox](#ejercicio-7--checkbox)
9.  [Ejercicio 8 — Radiobutton](#ejercicio-8--radiobutton)
10. [Ejercicio 9 — Slider](#ejercicio-9--slider)
11. [Ejercicio 10 — Card](#ejercicio-10--card)
12. [Ejercicio 11 — Dialog](#ejercicio-11--dialog)
13. [Ejercicio 12 — Proyecto](#ejercicio-12--proyecto)

---

## Creación del proyecto

* **Nombre del proyecto:** `bloqueCompose`
* **Tipo:** `Empty Activity`
* **Lenguaje:** **Kotlin**
* **Min SDK:** API 24

---

## Ejercicio 1 — Text

**Explicación:** Lo que he hecho ha sido tocar y jugar un poco con los diferentes estilos que puede tener un `Text`, jugando con los grosores de las fuentes, estilos, colores, y distintos tamaños.También he añadido un `Divider` para separar los textos y que no se vean tan juntos.

**Código:** https://github.com/gromber05/bloqueCompose/blob/b07f5bc40dac965fc4f967ced59579a5e1648c36/app/src/main/java/com/gromber05/bloquecompose/ejercicios/Ej01.kt#L22-L74

**Foto:** 
![Foto del ejercicio 1](images/ej1.jpg)

---

## Ejercicio 2 — TextField

**Explicación:** En este ejercicio lo que he hecho ha sido establecer dentro de una columna, tres campos OutlinedTextField que son como los TextField normales pero sus bordes están marcados para que se puedan ver mejor la zona que ocupan. Tienen todos variables para que si están vacíos los campos, salte un error y un texto de color resaltando el error.

**Código:** https://github.com/gromber05/bloqueCompose/blob/b07f5bc40dac965fc4f967ced59579a5e1648c36/app/src/main/java/com/gromber05/bloquecompose/ejercicios/Ej02.kt#L25-L113

**Foto:**
![Foto del ejercicio 2](images/ej2.jpg)

---

## Ejercicio 3 — Button

**Explicación:** Básicamente, en este ejercicio lo que he hecho ha sido establecer dos botones que sumen o resten de una variabla que se mustra en el texto que simula el título. En este ejercicio, el primer botón no se activa si la variable `count` no es mayor que cero
 
**Código:**  https://github.com/gromber05/bloqueCompose/blob/b07f5bc40dac965fc4f967ced59579a5e1648c36/app/src/main/java/com/gromber05/bloquecompose/ejercicios/Ej03.kt#L22-L50

**Foto:** 
![Foto del ejercicio 3](images/ej3.jpg)

---

## Ejercicio 4 — Image

**Explicación:** En este ejercicio, lo que he hecho ha sido una galeria de elementos que se han mostrado usando el componente de recursos de jetpack compose. Lo que tiene de especial es que hace uso de un repeat para proyectar las tres imágenes ya que cada una tiene el mismo ID en la carpeta drawable a diferencia de un número que es el que cambia para poder diferenciar las imágenes. Luego, también tiene un botón en forma de corazón que se colorea al pulsarse y hace que cambie el texto que tiene al lado.

**Código:** https://github.com/gromber05/bloqueCompose/blob/b07f5bc40dac965fc4f967ced59579a5e1648c36/app/src/main/java/com/gromber05/bloquecompose/ejercicios/Ej04.kt#L36-L107

**Foto:**
![Foto del ejercicio 4](images/ej4.jpg)

---

## Ejercicio 5 — Progress

**Explicación:** Este ejercicio funciona lanzando una corrutina cuando la variable `isLoading` está en true. Cambia el valor del texto a cargando y después de tres segundos que ha terminado el ProgressIndicator, vuelve a cambiar el texto a "Carga Completada".

**Código:** https://github.com/gromber05/bloqueCompose/blob/b07f5bc40dac965fc4f967ced59579a5e1648c36/app/src/main/java/com/gromber05/bloquecompose/ejercicios/Ej05.kt#L22-L61

**Foto:**
![Foto del ejercicio 5](images/ej5.jpg)

---

## Ejercicio 6 — Switch

**Explicación:** 

**Código:** https://github.com/gromber05/bloqueCompose/blob/b07f5bc40dac965fc4f967ced59579a5e1648c36/app/src/main/java/com/gromber05/bloquecompose/ejercicios/Ej06.kt#L25-L63

**Foto:** 
![Foto del ejercicio 6](images/ej6.jpg)

---

## Ejercicio 7 — CheckBox

**Explicación:** 

**Código:** https://github.com/gromber05/bloqueCompose/blob/b07f5bc40dac965fc4f967ced59579a5e1648c36/app/src/main/java/com/gromber05/bloquecompose/ejercicios/Ej07.kt#L13-L52

**Foto:**
![Foto del ejercicio 7](images/ej7.jpg)

---

## Ejercicio 8 — RadioButton

**Explicación:** 

**Código:** https://github.com/gromber05/bloqueCompose/blob/b07f5bc40dac965fc4f967ced59579a5e1648c36/app/src/main/java/com/gromber05/bloquecompose/ejercicios/Ej08.kt#L13-L48

**Foto:** 
![Foto del ejercicio 8](images/ej8.jpg)

---

## Ejercicio 9 — Slider

**Explicación:** 

**Código:** https://github.com/gromber05/bloqueCompose/blob/b07f5bc40dac965fc4f967ced59579a5e1648c36/app/src/main/java/com/gromber05/bloquecompose/ejercicios/Ej09.kt#L25-L57

**Foto:** 
![Foto del ejercicio 9](images/ej9.jpg)

---

## Ejercicio 10 — Card

**Explicación:** 

**Código:** https://github.com/gromber05/bloqueCompose/blob/b07f5bc40dac965fc4f967ced59579a5e1648c36/app/src/main/java/com/gromber05/bloquecompose/ejercicios/Ej10.kt#L32-L122

**Foto:**
![Foto del ejercicio 10](images/ej10.jpg)

---

## Ejercicio 11 — Dialog

**Explicación:** 

**Código:** https://github.com/gromber05/bloqueCompose/blob/b07f5bc40dac965fc4f967ced59579a5e1648c36/app/src/main/java/com/gromber05/bloquecompose/ejercicios/Ej11.kt#L31-L97

**Foto:** 
![Foto del ejercicio 11](images/ej11.jpg)

---

## Ejercicio 12 — Proyecto

**Explicación:** 

**Código:** https://github.com/gromber05/bloqueCompose/blob/b07f5bc40dac965fc4f967ced59579a5e1648c36/app/src/main/java/com/gromber05/bloquecompose/ejercicios/Ej12.kt#L34-L306

**Foto:** 
![Foto del ejercicio 12](images/ej12.jpg)

---
