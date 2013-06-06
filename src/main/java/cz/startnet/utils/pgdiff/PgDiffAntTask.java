package cz.startnet.utils.pgdiff;
/**
 *
 * Distributed under MIT license
 */
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffArguments;

/**
 * Run PgDiff As Ant Task Add a new paramter "outputDiffFile" for output result
 * to File int ant task. the other arguments are the same as PgDiff in
 * commond-line.
 * 
 * @author ylyxf
 * 
 */
public class PgDiffAntTask extends PgDiffArguments {

	/** the diff result file */
	private String outputDiffFile;

	public String getOutputDiffFile() {
		return outputDiffFile;
	}

	public void setOutputDiffFile(String outputDiffFile) {
		this.outputDiffFile = outputDiffFile;
	}

	public void execute() {
		try {
			FileOutputStream out = new FileOutputStream(outputDiffFile);
			PrintWriter encodedWriter = new PrintWriter(new OutputStreamWriter(
					out, this.getOutCharsetName()));
			PgDiff.createDiff(encodedWriter, this);
			encodedWriter.close();
		} catch (Exception e) {
			System.err.print(e);

		}

	}
}
