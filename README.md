
# Actualización de Libros en Grails

<img src="https://cloud.githubusercontent.com/assets/4549002/18517870/40a22aee-7a74-11e6-99e0-211e44d7bacf.png" width="100px;" height="100px;"/>

## Explicación

Se encuentra en [este apunte](https://docs.google.com/document/d/1g9Q7TxWU5hJu6_V8r63eSCek1EC1PCTL-f310XzDANE/edit#heading=h.z0vrvi6xk0zu)
donde se cuenta la navegación entre

* la pantalla de búsqueda
* y la edición/consulta de un libro

## Consideraciones

* Instalar el plugin de xtend a partir de Install New Software... utilizando [este update site](http://download.eclipse.org/modeling/tmf/xtext/updates/composite/releases/)
* El objeto de dominio es propio de Grails (utiliza GORM - Active Record)
* El manejo transaccional es responsabilidad de un Service de Grails
* Los controllers y las vistas son propias de Grails

## Versiones actuales

* Grails 2.4.2
* en un entorno GGTS 3.6.0
* con Twitter Boostrap 3.2.0
* con una JDK < 1.8 (para que no aparezcan warnings)
