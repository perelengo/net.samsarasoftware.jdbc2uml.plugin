package net.samsarasoftware.jdbc2uml.maven.plugin;

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

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import net.samsarasoftware.jdbc2uml.Jdbc2uml;

@Mojo(name = "jdbc2uml")
public class Jdbc2UmlMavenPlugin extends AbstractMojo{
	@Parameter( property = "jdbcDriverClass" ,required=true)
	private String jdbcDriverClass=null;
	
	@Parameter( property = "jdbcUrl"  ,required=true)
	private String jdbcUrl=null;
	
	@Parameter( property = "user"  ,required=true)
	private String user=null;
	
	@Parameter( property = "password" ,required=true)
	private String password=null;
	
	@Parameter( property = "catalogName"  ,required=false)
	private String catalogName=null;
	
	@Parameter( property = "schemaName"  ,required=false)
	private String schemaName=null;
	
	@Parameter( property = "dtypeColumnName",required=false )
	private String dtypeColumnName=null;
	
	@Parameter( property = "outputFileName",required=false )
	private String outputFileName=null;

	
	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		try {
			Jdbc2uml jdbc2uml=new Jdbc2uml(jdbcDriverClass, jdbcUrl, user, password, catalogName, schemaName, dtypeColumnName,outputFileName);
			jdbc2uml.run();
		} catch (Exception e) {
			e.printStackTrace();
			throw new org.apache.maven.plugin.MojoExecutionException(e.getMessage(),e);
		}			
	}
	
}    	
	
