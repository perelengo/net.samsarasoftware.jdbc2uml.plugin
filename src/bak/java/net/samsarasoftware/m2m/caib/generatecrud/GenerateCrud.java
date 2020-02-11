package net.samsarasoftware.m2m.caib.generatecrud;

/*-
 * #%L
 * generateCrud
 * %%
 * Copyright (C) 2014 - 2017 Pere Joseph Rodriguez
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 * #L%
 */

import java.io.IOException;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.eclipse.emf.common.util.URI;

import com.samsarasoftware.license.licenses.SamsaraSoftwareProductLicense;

import net.samsarasoftware.m2m.qvto.In;
import net.samsarasoftware.m2m.qvto.InOut;
import net.samsarasoftware.m2m.qvto.QVTOExecutor;
import net.samsarasoftware.m2m.qvto.QVTOExecutor.QVTOMojo;

@Mojo( name = "GenerateCrud")
public class GenerateCrud extends QVTOMojo {
    
	   
		@Override
		public void execute() throws MojoExecutionException, MojoFailureException {
			QVTOExecutor executor = new QVTOExecutor();
			executor.isEncrypted=true;
			executor.setProductLicense(new SamsaraSoftwareProductLicense());
			executor.INPUT.add(new InOut(URI.createFileURI(inputFilePath)));
			executor.INPUT.add(new In(URI.createURI("pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml")));
			executor.INPUT.add(new In(URI.createPlatformPluginURI("net.samsarasoftware.metamodels/profiles/maven.profile.uml",false)));
			executor.INPUT.add(new In(URI.createURI("pathmap://UML_PROFILES/Standard.profile.uml")));
			executor.INPUT.add(new In(URI.createPlatformPluginURI("net.samsarasoftware.metamodels/profiles/ejb3.profile.uml",false)));
			executor.INPUT.add(new In(URI.createPlatformPluginURI("net.samsarasoftware.metamodels/profiles/jpa.profile.uml",false)));
			executor.INPUT.add(new In(URI.createPlatformPluginURI("net.samsarasoftware.metamodels/profiles/dojo.profile.uml",false)));
			executor.INPUT.add(new In(URI.createPlatformPluginURI("net.samsarasoftware.metamodels/profiles/http.profile.uml",false)));
			executor.INPUT.add(new In(URI.createPlatformPluginURI("net.samsarasoftware.metamodels/profiles/jsonrpc.profile.uml",false)));
			executor.INPUT.add(new In(URI.createPlatformPluginURI("net.samsarasoftware.metamodels/profiles/xadisk.profile.uml",false)));
			executor.INPUT.add(new In(URI.createPlatformPluginURI("net.samsarasoftware.metamodels/profiles/jbossEap5.profile.uml",false)));
			//executor.INPUT.add(executor.new In(URI.createURI("pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml")));
			executor.QVTO_URI=URI.createURI(this.getClass().getResource("/"+this.getClass().getSimpleName()+".qvto").toString());
			
			
			
			try {
				executor.run();
			} catch (IOException e) {
				getLog().error(e);
			}			
		}
    	
	
}
