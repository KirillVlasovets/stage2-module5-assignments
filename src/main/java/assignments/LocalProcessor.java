package assignments;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

@Getter
@Setter
public class LocalProcessor {
    private StringBuilder processorName;
    private Long period = 10_000_000_000_000L;
    private StringBuilder processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringLinkedList = new LinkedList<>();
    private Logger logger = Logger.getLogger("LocalProcessor logger");

    public LocalProcessor(StringBuilder processorName, Long period, StringBuilder processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringLinkedList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringLinkedList = stringLinkedList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        stringLinkedList = new LinkedList<>(stringList);
        for (String stringLinkedListElement : stringLinkedList) {
            System.out.println(String.valueOf(stringLinkedListElement).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(LinkedList<String> stringLinkedList) {
        for (String stringLinkedListElement : this.stringLinkedList) {
            processorName.append(stringLinkedListElement).append(" ");
        }
        return String.valueOf(processorName);
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) {
            try {
                informationScanner = new Scanner(file);
                while (informationScanner.hasNext()) {
                    processorVersion.append(informationScanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                logger.warning(e.getMessage());
            } finally {
                informationScanner.close();
            }
    }
}
