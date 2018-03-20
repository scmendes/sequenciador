package org.smendes.tasklist.monitor;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

import org.smendes.tasklist.entity.Tasklist;

public class FilesMonitor {

	
	private static final String ROOT_FOLDER = "C:\\scmendes\\SOFTWARE EXPRESS SEQUENCIADOR\\";

	private static final String ERROR_FOLDER = "erro";
	private static final String MERGE_FOLDER = "merge";
	private static final String NEW_FOLDER = "novo";
	private static final String PROC_FOLDER = "proc";
	private static final String TEMP_FOLDER = "temp";
	
	public FilesMonitor() {
		super();
	}

	public static void main(String[] args) {
		FilesMonitor fm = new FilesMonitor();
		fm.monitor();
	}
	
	
	public Tasklist monitor() {
		
		Tasklist result = new Tasklist();
		
		String folderName = "";
		int totalFiles = -1;
		
		folderName = ROOT_FOLDER + ERROR_FOLDER;
		totalFiles = countFiles(folderName, "txt");
		System.out.println("TOTAL DE ARQUIVOS NA PASTA " + folderName + "=" + totalFiles);
		result.setErrorTotalFiles(totalFiles);
		
		folderName = ROOT_FOLDER + MERGE_FOLDER;
		totalFiles = countFiles(folderName, "txt");
		System.out.println("TOTAL DE ARQUIVOS NA PASTA " + folderName + "=" + totalFiles);
		result.setMergeTotalFiles(totalFiles);

		folderName = ROOT_FOLDER + NEW_FOLDER;
		totalFiles = countFiles(folderName, "txt");
		System.out.println("TOTAL DE ARQUIVOS NA PASTA " + folderName + "=" + totalFiles);
		result.setNewTotalFiles(totalFiles);

		folderName = ROOT_FOLDER + PROC_FOLDER;
		totalFiles = countFiles(folderName, "txt");
		System.out.println("TOTAL DE ARQUIVOS NA PASTA " + folderName + "=" + totalFiles);
		result.setProcTotalFiles(totalFiles);

		folderName = ROOT_FOLDER + TEMP_FOLDER;
		totalFiles = countFiles(folderName, "txt");
		System.out.println("TOTAL DE ARQUIVOS NA PASTA " + folderName + "=" + totalFiles);		
		result.setTempTotalFiles(totalFiles);

		return result;
	}
	
	
	public int countFiles(final String folderName, final String extensao) {
		
		File path = new File(folderName);
		
		int quantidade = 0;
		if ( path == null ) throw new RuntimeException("Deve ser informado um diretorio!");
		if ( !path.exists() ) throw new RuntimeException("Diretorio nao existe. ["+path.getAbsolutePath()+"]");
		if ( !path.isDirectory() ) throw new RuntimeException("Deve ser informado um diretorio. ["+path.getAbsolutePath()+"]");
		if ( !path.canRead() ) throw new RuntimeException("Sem permissao no diretorio. ["+path.getAbsolutePath()+"]");
		
		
		quantidade = path.list(new FiltroArquivo(Pattern.compile(".*"+extensao))).length;

		return quantidade;
	}	
	
	private class FiltroArquivo implements FilenameFilter{
		private final Pattern jexl;
		public FiltroArquivo(Pattern expressaoRegular) {
			this.jexl  = expressaoRegular;
		}
		public boolean accept(File path, String nome) {
			return jexl.matcher(nome).matches();
		}
	}

}
