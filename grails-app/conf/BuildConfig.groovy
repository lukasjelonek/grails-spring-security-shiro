grails.project.work.dir = 'target'
grails.project.docs.output.dir = 'docs/manual' // for backwards-compatibility, the docs are checked into gh-pages branch

grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

	repositories {
		grailsCentral()
		mavenLocal()
		mavenCentral()
		mavenRepo 'http://repo.spring.io/milestone' // TODO remove
	}

	dependencies {

		String shiroVersion = '1.2.2'
		def common = ['easymock', 'groovy-all', 'jcl-over-slf4j', 'junit', 'log4j', 'slf4j-log4j12']

		compile "org.apache.shiro:shiro-aspectj:$shiroVersion", {
			excludes((common + ['aspectjrt', 'aspectjweaver']) as Object[])
		}

		compile "org.apache.shiro:shiro-core:$shiroVersion", {
			excludes((common + ['commons-beanutils', 'hsqldb', 'slf4j-api']) as Object[])
		}

		compile "org.apache.shiro:shiro-spring:$shiroVersion", {
			excludes((common + ['servlet-api', 'spring-context', 'spring-test']) as Object[])
		}

		compile "org.apache.shiro:shiro-web:$shiroVersion", {
			excludes((common + ['jsp-api', 'jstl', 'servlet-api']) as Object[])
		}
	}

	plugins {
		compile ':spring-security-core:2.0-RC2'

		compile(":hibernate:$grailsVersion") {
			export = false
		}

		build ':release:2.2.1', ':rest-client-builder:1.0.3', {
			export = false
		}
	}
}
