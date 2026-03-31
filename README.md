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

🖼️ ## Vista principal de la aplicación:

<p align="center">
  <img src="img/captura-app.jpg" alt="Captura de pantalla de la app" width="300"/>
</p>

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
└── img/captura-app.jpg
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


## 👨‍💻 Autor / Integrantes

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

Además de resolver la conversión entre monedas, el trabajo nos ayudo a aprender sobre de organización en capas, separación de responsabilidades y validación de entradas, cumpliendo con los objetivos principales del trabajo asignado.

