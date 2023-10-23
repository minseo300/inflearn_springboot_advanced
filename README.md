# Spring docs 정리
## core
	1. Introduction to the Spring IoC Container and Beans
> **Inversion of Control - Dependency Injection**
		* factory method에 대한 arguments
		* constructor arguments
		* factory method에서 반환된 후 object instance에 설정된 properties를 통해서만 
		종속성을 정의하는 프로세스
		컨테이너는 bean을 생성할 때 종속성을 주입

 * org.springframework.beans, org.springframework.context
	 * BeanFactory interface: 모든 type의 object를 관리할 수 있는 advanced configuration 메커니즘 제공
	* ApplicationContext: BeanFactory의 sub-interface로 enterprise-specific 기능을 추가로 제공
	* Bean은 IoC 컨테이너에 의해 인스턴스화, 어셈블 및 관리되는 객체로 IoC 컨테이너에 의해 관리되지 않으면 그냥 일반 객체와 동일.
		* 빈과 빈 간의 dependency는 컨테이너에서 사용되는 configuration metadata에 반영됨.

<img width="1086" alt="Screenshot 2023-10-23 at 10 03 11 PM" src="https://github.com/minseo300/inflearn_springboot_advanced/assets/76048180/6fb19602-bc67-417d-9be9-493e3d93631a">

  

		

				
