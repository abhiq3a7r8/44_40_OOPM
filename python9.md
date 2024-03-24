# Experiment No .7


### Aim :
Creating a web application using Django web framework to demonstrate functionality of user login and registration (also validating the user detail using regular expression)

### Theory: 





Django is a high-level Python web framework that encourages rapid development and clean, pragmatic design. It provides built-in tools for creating web applications, including authentication and validation features. In this example, we'll focus on creating a simple web application that allows users to register, log in, and validate their registration details using regular expressions.

### 1. Installation

First, we'll need to have Django installed. You can install Django using pip, the Python package installer:

```bash
pip install django
```

### 2. Create a Django Project

We can create a new Django project using the following command:

```bash
django-admin startproject myproject
```

Navigate into the project directory:

```bash
cd myproject
```

### 3. Create a Django App

A Django project is made up of one or more apps. You can create a new app using the following command:

```bash
python manage.py startapp myapp
```

### 4. Define Models

In Django, models are used to define the structure of your data. For our user registration and login system, we'll use Django's built-in `User` model, which comes with authentication features.

![](@attachment/Clipboard_2024-03-24-14-51-24.png)

### 5. Create Views

Views in Django are Python functions or classes that take a web request and return a web response. We'll create views for user registration, login, and logout.

![](@attachment/Clipboard_2024-03-24-14-59-12.png)

### 6. Create Templates

Templates are used to generate HTML dynamically. We'll create templates for user registration, login, and the home page.

![](@attachment/Clipboard_2024-03-24-14-58-41.png)

### 7. URL Configuration

URLs in Django are defined in the `urls.py` file. We'll define URLs for our user registration, login, logout, and home page.

![](@attachment/Clipboard_2024-03-24-14-59-50.png)

### 8. User Registration

To register a new user, we'll create a form using Django's `forms.Form` class. We'll validate the form input, including using regular expressions to validate email addresses, passwords, etc.

![](@attachment/Clipboard_2024-03-24-15-01-58.png)

![](@attachment/Clipboard_2024-03-24-15-02-55.png)

### 9. User Login

For user login, we'll create a login form using Django's built-in `AuthenticationForm`. This form will authenticate users based on their username and password.

![](@attachment/Clipboard_2024-03-24-15-04-10.png)

![](@attachment/Clipboard_2024-03-24-15-04-30.png)

### 10. Logout

To allow users to log out, we'll create a logout view that logs the user out and redirects them to the home page.

![](@attachment/Clipboard_2024-03-24-15-06-14.png)

### 11. Regular Expression Validation

We'll use regular expressions (regex) to validate user input, such as email addresses and passwords. Django provides a `validators` module that we can use with our form fields.

![](@attachment/Clipboard_2024-03-24-15-11-38.png)
  




![](@attachment/Clipboard_2024-03-24-15-09-23.png)

### Conclusion:

Django, as a powerful web framework written in Python, provides a robust ecosystem for building web applications with efficiency and scalability. Offering a rich set of tools and libraries, Django simplifies the development process by automating common web development tasks, including user authentication, database management, URL routing, and form handling. Its built-in security features and adherence to best practices ensure robust protection against common web vulnerabilities. Django's model-view-template (MVT) architecture promotes clean and maintainable code, facilitating rapid development without sacrificing flexibility. With Django, developers can create feature-rich web applications with ease, focusing on application logic rather than low-level implementation details, ultimately resulting in reliable, secure, and scalable web solutions.


