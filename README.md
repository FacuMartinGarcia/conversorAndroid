# 💱 Conversor de Moneda USD ↔ EUR (Android + Java + MVVM)

Desarrollamos esta Aplicación móvil en **Android Studio con Java** que permite convertir valores entre **Dólares (USD)** y **Euros (EUR)**, implementando el patrón de arquitectura **MVVM (Model - View - ViewModel)**.

Este proyecto fue realizado como parte de un **Trabajo Práctico de Programación Móvil**, con el objetivo de aplicar una arquitectura limpia, separar responsabilidades entre capas y utilizar **LiveData** para la comunicación entre la lógica y la interfaz.

---

## 📌 Descripción del proyecto

La aplicación permite al usuario:

- Ingresar un monto en **Dólares** o **Euros**.
- Seleccionar el tipo de conversión mediante **RadioButtons**:
  - **Convertir a Dólares**
  - **Convertir a Euros**
- Ejecutar la conversión con el botón **Convertir**.
- Ver el resultado directamente en el campo correspondiente.
- Consultar y modificar la **cotización actual** mediante el botón **Cambiar Valor**.

La lógica de negocio está desacoplada de la interfaz gracias al patrón **MVVM**, lo que permite una mejor organización del código, mayor mantenibilidad y una estructura más cercana a buenas prácticas de desarrollo Android.

---

## 🎯 Objetivos del trabajo práctico

- Aplicar el patrón de arquitectura **MVVM** en una aplicación Android real.
- Separar correctamente la lógica de negocio de la interfaz gráfica.
- Utilizar **LiveData** para comunicar cambios entre capas.
- Manejar eventos del usuario desde la vista y procesarlos en el ViewModel.
- Validar entradas y controlar errores de forma simple y clara.

---

## 🚀 Funcionalidades implementadas

- ✅ Conversión de **USD a EUR**
- ✅ Conversión de **EUR a USD**
- ✅ Selección del tipo de conversión con **RadioButtons**
- ✅ Campo editable para modificar la **cotización**
- ✅ Botón **Convertir**
- ✅ Botón **Cambiar Valor**
- ✅ Visualización del resultado en el campo correspondiente
- ✅ Habilitación dinámica del campo de entrada según la conversión seleccionada
- ✅ Limpieza automática de campos al cambiar el tipo de conversión
- ✅ Validación de valores numéricos
- ✅ Manejo de errores mediante **Toast**

---

## 🧠 Arquitectura MVVM aplicada

El proyecto implementa el patrón **MVVM (Model - View - ViewModel)** de la siguiente manera:

### 🔹 Model → `Conversor.java`
Ubicación:
```bash
app/src/main/java/com/desarrolloar/conversor/modelo/Conversor.java
````

**Responsabilidades:**

* Mantener la **cotización actual**
* Exponer métodos para convertir:

  * `convertirADolares(double euros)`
  * `convertirAEuros(double dolares)`

**Lógica implementada:**

* `euros / cotizacion` → convierte de EUR a USD
* `dolares * cotizacion` → convierte de USD a EUR

Es la clase encargada de la **lógica de negocio pura**.

---

### 🔹 ViewModel → `MainActivityViewModel.java`

Ubicación:

```bash
app/src/main/java/com/desarrolloar/conversor/MainActivityViewModel.java
```

**Responsabilidades:**

* Gestionar el estado de la interfaz usando **LiveData**
* Recibir acciones desde la vista
* Validar entradas
* Invocar la lógica del modelo
* Exponer resultados y mensajes a la UI

**LiveData utilizados:**

* `mostrarEuros`
* `mostrarDolares`
* `mensajeToast`
* `resultadoEuros`
* `resultadoDolares`
* `limpiarCampos`
* `tipoConversion`

**Funciones principales:**

* `setSeleccionMoneda(...)`
* `cambiarCotizacion(String textoCotizacion)`
* `convertir(String textoEuros, String textoDolares)`
* `getCotizacionActual()`

**Detalle importante:**

* La cotización inicial se define en el constructor:

```java
conversor = new Conversor(0.87);
```

---

### 🔹 View → `MainActivity.java`

Ubicación:

```bash
app/src/main/java/com/desarrolloar/conversor/MainActivity.java
```

**Responsabilidades:**

* Inicializar la interfaz
* Conectar la vista con el `ViewModel`
* Observar los `LiveData`
* Capturar eventos del usuario
* Actualizar la UI según los cambios

**Qué hace concretamente:**

* Inicializa `ViewBinding`
* Obtiene el `ViewModel` con `ViewModelProvider`
* Configura la `Toolbar`
* Muestra la cotización inicial en `etCambio`
* Escucha la selección del `RadioGroup`
* Habilita/deshabilita campos según la conversión
* Llama a `cambiarCotizacion(...)`
* Llama a `convertir(...)`
* Muestra mensajes con `Toast`
* Limpia campos cuando cambia la selección
* Define una opción por defecto con `inicializarPorDefecto()`

> La Activity actúa como **capa visual**, mientras que la lógica de conversión y validación queda delegada al `ViewModel` y al `Model`.

---

## 🖼️ Interfaz de usuario (XML)

Archivo:

```bash
app/src/main/res/layout/activity_main.xml
```

La interfaz está construida con un **RelativeLayout** e incluye:

* **Toolbar** personalizada con título e ícono
* `EditText` para **Dólares**
* `EditText` para **Euros**
* `EditText` para la **cotización**
* `RadioGroup` con:

  * `rbDolares`
  * `rbEuros`
* Botón **Convertir**
* Botón **Cambiar Valor**
* `TextView` descriptivos para cada campo

### Comportamiento visual

* Según la opción elegida:

  * Si se selecciona **Convertir a Dólares**, se habilita el campo **Euros**
  * Si se selecciona **Convertir a Euros**, se habilita el campo **Dólares**
* Los campos se limpian automáticamente al cambiar el tipo de conversión

---

## 🛠️ Tecnologías utilizadas

* **Java**
* **Android Studio**
* **XML**
* **Android Jetpack**

  * **ViewModel**
  * **LiveData**
* **ViewBinding**
* **Gradle Kotlin DSL (`build.gradle.kts`)**

---

## 📂 Estructura real del proyecto

```bash
conversorAndroid-main/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/desarrolloar/conversor/
│   │   │   │   ├── MainActivity.java
│   │   │   │   ├── MainActivityViewModel.java
│   │   │   │   └── modelo/
│   │   │   │       └── Conversor.java
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   └── activity_main.xml
│   │   │   │   ├── values/
│   │   │   │   ├── drawable/
│   │   │   │   ├── mipmap-*/
│   │   │   │   └── xml/
│   │   │   └── AndroidManifest.xml
│   │
│   ├── build.gradle.kts
│   └── proguard-rules.pro
│
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

---

## ⚙️ Cómo ejecutar el proyecto

1. Clonar el repositorio:

```bash
git clone https://github.com/FacuMartinGarcia/conversorAndroid
```

2. Abrir el proyecto en **Android Studio**

3. Esperar a que Android Studio sincronice las dependencias con **Gradle**

4. Ejecutar la app en:

* un **emulador Android**
* o un **dispositivo físico**

---

## 🧪 Validaciones implementadas

Incluimos validaciones simples pero correctas para cumplir con la consigna:

### En `cambiarCotizacion(...)`

* Verifica que la cotización:

  * no esté vacía
  * sea numérica
  * sea mayor a `0`

Si no cumple:

* muestra el mensaje:

```text
Ingrese una cotización válida
```

### En `convertir(...)`

* Verifica que haya una opción seleccionada
* Verifica que el valor ingresado:

  * no esté vacío
  * sea numérico válido

Mensajes posibles:

* `Seleccioná una opción`
* `Ingrese un valor válido en euros`
* `Ingrese un valor válido en dólares`

### En `parseNumero(...)`

* Acepta tanto **coma** como **punto** decimal:

  * ejemplo: `10,5` o `10.5`
* Esto mejora la usabilidad para diferentes usuarios usuarios  

---

## ✨ Aspectos destacables de la implementación

* Buena separación entre **View**, **ViewModel** y **Model**
* Uso correcto de **LiveData**
* Uso de **ViewBinding** en lugar de `findViewById`
* El `ViewModel` centraliza:

  * estado de la UI
  * validaciones
  * lógica de flujo
* El `Model` se mantiene simple y enfocado en el cálculo

---

## 🔍 Posibles mejoras futuras

Si bien el proyecto cumple bien con la consigna, podriamos aplicar varias mejoras en el futuro:

### 1. Mostrar la cotización de forma más clara

Actualmente se muestra solo el número (`0.87`) en el campo `etCambio`.

**Mejora sugerida:**
Mostrar algo como:

```text
1 USD = 0.87 EUR
```

---

### 2. Mejorar el diseño visual

La interfaz funciona correctamente, pero se podría modernizar con:

* `ConstraintLayout`
* Componentes de **Material Design**
* Mejor espaciado y alineación
* Uso de `TextInputLayout`

---

### 3. Evitar usar `EditText` para mostrar resultados

Actualmente el resultado se escribe en los mismos `EditText`.

**Mejora sugerida:**

* usar un `TextView` para mostrar resultados
* dejar un solo campo editable para el valor de entrada

Esto haría la UX más clara.

---

### 4. Extraer mensajes a `strings.xml`

Los textos como:

* `"Ingrese una cotización válida"`
* `"Cotización actualizada"`
* `"Seleccioná una opción"`

podrían moverse a `strings.xml` para:

* mejor mantenimiento
* soporte futuro para internacionalización

---

### 5. Agregar persistencia de cotización

La cotización vuelve a `0.87` al reiniciar la app.

**Mejora sugerida:**
Guardar la cotización en:

* `SharedPreferences`

---

### 6. Crear una capa `Repository`

Aunque para este proyecto no es obligatorio, sería una mejora arquitectónica interesante:

* `View -> ViewModel -> Repository -> Model`

Esto sería útil si en el futuro se quisiera:

* consumir una API real
* persistir datos localmente

---

### 7. Incorporar pruebas unitarias reales

El proyecto trae los tests por defecto (`ExampleUnitTest` y `ExampleInstrumentedTest`), pero no tests funcionales del conversor.

**Mejoras sugeridas:**

* testear `Conversor`
* testear `parseNumero(...)`
* testear `convertir(...)`

---

## 📚 Aprendizajes logrados

Este proyecto permitió poner en práctica:

* Arquitectura **MVVM**
* Separación de responsabilidades
* Uso de **LiveData**
* Gestión del estado de la interfaz
* Validaciones de entrada
* Manejo de eventos del usuario
* Uso de **ViewBinding**
* Organización de un proyecto Android en capas

---

## 👨‍💻 Autor / Integrantes

Proyecto desarrollado para la materia **Programación Móvil**.

**Integrantes del grupo:**

* Facundo Martín García
* Victor Angel Aguilera
* Rafael Nicolas Cuello

---

## 📎 Repositorio

Repositorio público del proyecto:

[🔗 conversorAndroid](https://github.com/FacuMartinGarcia/conversorAndroid)

---

## ✅ Conclusión

Este proyecto representa una implementación práctica y correcta de una aplicación Android simple, aplicando el patrón **MVVM** con **Java**, **LiveData** y **ViewBinding**.

Además de resolver la conversión entre monedas, el trabajo nos ayudo a aprnder sobre de organización en capas, separación de responsabilidades y validación de entradas, cumpliendo con los objetivos principales del trabajo asignado.

