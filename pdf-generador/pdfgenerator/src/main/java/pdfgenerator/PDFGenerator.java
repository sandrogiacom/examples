package pdfgenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class PDFGenerator {
	
	private static String TEMPLATE = "resources/templates/scratch/Certificado Scratch 1 modelo.pdf";

	public static void main(String[] args) throws IOException {
		
		List<String> names = Collections.emptyList();
		
		String inputFile = args.length > 0 ? args[0]: null;
		
		if (inputFile == null) {
			System.out.println("Arquivo de dados não informado. Usando o modelo scratch1.csv");
		}
		
		if (inputFile == null) {
			inputFile = "scratch1.csv";
		}
		
		try {
			names = readFile("resources/input/" + inputFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String outDir = null;
		
		try {
			String path = new File(".").getCanonicalPath();
			File out = new File(path+ "/out");
			out.mkdir();
			outDir = out.getAbsolutePath();
		} catch (Exception e) {	}
		
		String lider = names.get(0);

		PDAcroForm pDAcroForm = null;
		
		PDField field = null;
		
		for (int i = 1; i < names.size(); i++) {
			PDDocument pDDocument = PDDocument.load(new File(TEMPLATE)); 
			pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
			pDAcroForm.setNeedAppearances(false);
			field =  pDAcroForm.getField("txt_lider");
			field.setValue(lider);
			String aluno = names.get(i);
			field = pDAcroForm.getField("txt_aluno");
			field.setValue(aluno);
			//Flatten the document
			pDAcroForm.flatten();
			//Save the document
			pDDocument.save("out/" + aluno + ".pdf");
			pDDocument.close();
		}
		
		System.out.println(names.size() -1 + " arquivos gerados em: " + outDir);
		
		//merge files
		
		System.out.println("merge files...");
		
		PDFMergerUtility merge = new PDFMergerUtility();
		File[] files = new File("out").listFiles();
		System.out.println(files[0].getAbsolutePath());
		PDDocument destination = PDDocument.load(files[0]);
		for (int i = 1; i < files.length; i++) {
			File file = files[i];
			PDDocument source = PDDocument.load(file);
			System.out.println(file.getAbsolutePath());
			merge.appendDocument(destination, source);
		}
		
		merge.mergeDocuments(null);
		destination.save("out/merge.pdf");
		destination.close();
	}

	private static List<String> readFile(String file) throws Exception{
		List<String> names = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
		    for(String line; (line = br.readLine()) != null; ) {
		       names.add(line);
		    }
		}
		return names;
	}
	
}
