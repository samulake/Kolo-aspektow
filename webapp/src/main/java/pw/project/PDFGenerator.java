package pw.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import pw.project.Hero;
import pw.project.Strength;

public class PDFGenerator {
	private Hero hero;
	private Document document;
	private PdfPTable table;
	private List<String> proficiencies;
	private Font paragraphFont;

	public PDFGenerator(Hero hero) {
		this.hero = hero;
		document = new Document();
		// document.setMargins(5, 5, 5, 5);
		proficiencies = new ArrayList<String>();
		proficiencies.add("Walecznosc i zahartowanie");
		proficiencies.add("Kondycja i sprawnosc");
		proficiencies.add("Wiedza i obycie");
		proficiencies.add("Percepcja i empatia");
		proficiencies.add("Ekspresja i perswazja");
		proficiencies.add("Skrupulatnosc i precyzja");
		paragraphFont = new Font();
		paragraphFont.setStyle(Font.BOLD);
		paragraphFont.setSize(14);
		paragraphFont.setColor(BaseColor.GRAY);
	}

	public void generate() throws FileNotFoundException, DocumentException {
		PdfWriter.getInstance(document,
				new FileOutputStream(new File("C:\\Users\\Eryk\\workspace\\webapp\\pdf\\result.pdf")));
		document.open();
		setTitle("Kolo aspektów");
		addBasicData();
		addStrengthData();
		addAspectData();
		addOtherData();
		document.close();
	}

	private void setTitle(String title) throws DocumentException {
		Paragraph paragraph = new Paragraph();
		Font font = new Font();
		font.setSize(30);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		paragraph.setFont(font);
		paragraph.add(title);
		paragraph.setSpacingAfter(10);
		document.add(paragraph);
	}

	private void addBasicData() throws DocumentException {
		Paragraph paragraph = new Paragraph();
		table = new PdfPTable(2);
		Chunk chunk = new Chunk("Imie postaci: ");
		Font boldFont = new Font();
		boldFont.setStyle(Font.BOLD);
		chunk.setFont(boldFont);
		// table.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setBorder(0);
		table.addCell(chunk.getContent() + hero.getName());
		chunk = new Chunk("Donioslosc podstawowa: ");
		chunk.setFont(boldFont);
		table.addCell(chunk.getContent() + hero.getBaseSignificance() + "\n");
		chunk = new Chunk("Pula zaangazowania: ");
		chunk.setFont(boldFont);
		table.addCell(chunk.getContent() + hero.getInvolvementPool());
		chunk = new Chunk("Pula opowiesci: ");
		chunk.setFont(boldFont);
		table.addCell(chunk.getContent() + hero.getTalePool());
table.setSpacingAfter(10);
		document.add(table);
	}

	private void addStrengthData() throws DocumentException {
		Paragraph paragraph = new Paragraph();
		paragraph.setFont(paragraphFont);
		paragraph.add("Atuty");
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		paragraph.setSpacingAfter(5);
		
		
		PdfPTable table = new PdfPTable(3);
		PdfPCell cell = new PdfPCell(new Phrase("Nazwa")), cell2 = new PdfPCell(new Phrase("Sfera glowna")), cell3 = new PdfPCell(new Phrase("Sfera sasiednia")) ;
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);
		table.addCell(cell2);
		table.addCell(cell3);
		for (Strength strength : hero.getStrengthList()) {
			table.addCell(strength.getName());
			table.addCell(strength.getMainSphere());
			table.addCell(strength.getAdjoiningSphere());
		}

		document.add(paragraph);
		table.setSpacingAfter(10);
		document.add(table);
	}

	private void addAspectData() throws DocumentException {
		Paragraph paragraph = new Paragraph();
		paragraph.setFont(paragraphFont);
		paragraph.add("Aspekty");
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		
		addProficienciesDescription();
		PdfPTable table = new PdfPTable(7);
		table.setWidths(new int [] {15, 2, 2, 2, 2, 2, 2});
		PdfPCell cell;
		
		table.addCell("");
		table.addCell("I");
		table.addCell("II");
		table.addCell("III");
		table.addCell("IV");
		table.addCell("V");
		table.addCell("VI");
		
		PdfPCell cell2 = new PdfPCell(new Phrase("Aspekty tla"));
		cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell2);
		cell = new PdfPCell(new Phrase("Bieglosci ( 3 w jednym wierszu )"));
		cell.setColspan(6);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);

		

		for (Aspect backgroundAspect : hero.getBackgroundAspectList()) {
			table.addCell(backgroundAspect.getName());
			for (int i = 0; i < proficiencies.size(); i++) {
				if (backgroundAspect.getAssignedProficiencyList().contains(proficiencies.get(i))) {
					table.addCell("X");
				} else {
					table.addCell("");
				}
			}
		}
		cell2 = new PdfPCell(new Phrase("Aspekty roli"));
		cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell2);
		cell = new PdfPCell(new Phrase("Bieglosci ( 2 w jednym wierszu )"));
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setColspan(6);
		table.addCell(cell);
		
		for (Aspect backgroundAspect : hero.getRoleAspectList()) {
			table.addCell(backgroundAspect.getName());
			for (int i = 0; i < proficiencies.size(); i++) {
				if (backgroundAspect.getAssignedProficiencyList().contains(proficiencies.get(i))) {
					table.addCell("X");
				} else {
					table.addCell("");
				}
			}
		}
		
		cell2 = new PdfPCell(new Phrase("Aspekty skupienia"));
		cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell2);
		cell = new PdfPCell(new Phrase("Bieglosci ( 1 w jednym wierszu )"));
		cell.setColspan(6);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);
		for (Aspect backgroundAspect : hero.getFocusAspectList()) {
			table.addCell(backgroundAspect.getName());
			for (int i = 0; i < proficiencies.size(); i++) {
				if (backgroundAspect.getAssignedProficiencyList().contains(proficiencies.get(i))) {
					table.addCell("X");
				} else {
					table.addCell("");
				}
			}
		}
		paragraph.setSpacingAfter(5);
		document.add(paragraph);
		document.add(table);
	}
	

	private void addProficienciesDescription() throws DocumentException {
		Paragraph paragraph = new Paragraph();
		paragraph.setFont(paragraphFont);
		paragraph.add("Bieglosci");
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		
		paragraph.setSpacingAfter(5);
		PdfPTable table = new PdfPTable(2);
		table.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell("I Walecznosc i zahartowanie");
		table.addCell("II Kondycja i sprawnosc");
		table.addCell("III Wiedza i obycie");
		table.addCell("IV Percepcja i empatia");
		table.addCell("V Ekspresja i perswazja");
		table.addCell("VI Skrupulatnosc i precyzja");
		document.add(paragraph);
		table.setSpacingAfter(10);
		document.add(table);
	}

	private void addOtherData() throws DocumentException {
		addData("Sekrety", hero.getSecretList());
		addData("Zasoby", hero.getResourceList());
		addData("Znaczniki", hero.getTagList());
		addData("Doswiadczenie", hero.getExperienceList());
	}
	
	private void addData(String title, List<CharacteristicTrait> dataList) throws DocumentException {
		
		Paragraph titleParagraph = new Paragraph();
		titleParagraph.setFont(paragraphFont);
		titleParagraph.add(new Chunk(title));
		Paragraph paragraph = new Paragraph();
		titleParagraph.setAlignment(Paragraph.ALIGN_CENTER);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		//paragraph.add(Chunk.NEWLINE);
		for(CharacteristicTrait data: dataList) {
			paragraph.add(data.getName() + ", ");
		}
		paragraph.add(Chunk.NEWLINE);
		document.add(titleParagraph);
		document.add(paragraph);
	}
}
