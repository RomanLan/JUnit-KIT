package final2.subtests;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import test.Input;
import test.SystemExitStatus;
import test.runs.ExactRun;
import test.runs.NoOutputRun;
import test.runs.Run;

/**
 * Checks the {@code field} command.
 * 
 * @author Annika Berger
 *
 */
public class FieldTest extends LangtonSubtest {
	public FieldTest() {
		setAllowedSystemExitStatus(SystemExitStatus.WITH_0);
	}

	/**
	 * Asserts that command {@code field} works with simple examples.
	 */
	@Test
	public void simpleFieldTest() {
		runs = new Run[] {
				new ExactRun("field 0,0", is("0")),
				new ExactRun("field 1,0", is("0")),
				new ExactRun("field 2,0", is("0")),
				new ExactRun("field 0,1", is("0")),
				new ExactRun("field 0,2", is("0")),
				new ExactRun("field 1,1", is("0")),
				new ExactRun("field 1,2", is("0")),
				new ExactRun("field 2,1", is("f")),
				new ExactRun("field 2,2", is("0")),
				quit()
		};
		sessionTest(runs, Input.getFile(TASK_SHEET_INPUT_FILE_1));

		runs = new Run[] {
				new NoOutputRun("create b,1,0"),
				new ExactRun("field 0,0", is("0")),
				new ExactRun("field 1,0", is("b")),
				new ExactRun("field 2,0", is("0")),
				new ExactRun("field 0,1", is("0")),
				new ExactRun("field 0,2", is("0")),
				new ExactRun("field 1,1", is("0")),
				new ExactRun("field 1,2", is("0")),
				new ExactRun("field 2,1", is("f")),
				new ExactRun("field 2,2", is("0")),
				quit()
		};
		sessionTest(runs, Input.getFile(TASK_SHEET_INPUT_FILE_1));

		runs = new Run[] {
				new ExactRun("field 0,0", is("1")),
				new ExactRun("field 1,0", is("3")),
				new ExactRun("field 2,0", is("1")),
				new ExactRun("field 0,1", is("*")),
				new ExactRun("field 0,2", is("0")),
				new ExactRun("field 1,1", is("e")),
				new ExactRun("field 1,2", is("4")),
				new ExactRun("field 2,1", is("2")),
				new ExactRun("field 2,2", is("*")),
				quit()
		};
		sessionTest(runs, Input.getFile(TASK_SHEET_INPUT_FILE_2));

		runs = new Run[] {
				new NoOutputRun("create b,1,0"),
				new ExactRun("field 0,0", is("1")),
				new ExactRun("field 1,0", is("b")),
				new ExactRun("field 2,0", is("1")),
				new ExactRun("field 0,1", is("*")),
				new ExactRun("field 0,2", is("0")),
				new ExactRun("field 1,1", is("e")),
				new ExactRun("field 1,2", is("4")),
				new ExactRun("field 2,1", is("2")),
				new ExactRun("field 2,2", is("*")),
				new NoOutputRun("escape e"),
				new ExactRun("field 0,0", is("1")),
				new ExactRun("field 1,0", is("b")),
				new ExactRun("field 2,0", is("1")),
				new ExactRun("field 0,1", is("*")),
				new ExactRun("field 0,2", is("0")),
				new ExactRun("field 1,1", is("0")),
				new ExactRun("field 1,2", is("4")),
				new ExactRun("field 2,1", is("2")),
				new ExactRun("field 2,2", is("*")),
				quit()
		};
		sessionTest(runs, Input.getFile(TASK_SHEET_INPUT_FILE_2));
	}

	/**
	 * Asserts that {@code field} works on a test file with all ant and cell types. Please refer to
	 * {@link LangtonSubtest#ALL_TYPES_BOARD} for a detailed description of what is supposed to happen.
	 */
	@Test
	public void allTypesFieldTest() {
		runs = new Run[] {
				new ExactRun("field 0,1", is("b")),
				new ExactRun("field 2,1", is("*")),
				new ExactRun("field 1,2", is("4")),
				move(1),
				new ExactRun("field 2,0", is("c")),
				new ExactRun("field 2,1", is("*")),
				new ExactRun("field 2,2", is("i")),
				new ExactRun("field 2,3", is("s")),
				move(3),
				new ExactRun("field 2,0", is("0")),
				new ExactRun("field 2,1", is("*")),
				new ExactRun("field 2,2", is("3")),
				new ExactRun("field 2,3", is("s")),
				move(1),
				new ExactRun("field 0,0", is("3")),
				new ExactRun("field 0,1", is("0")),
				new ExactRun("field 0,2", is("3")),
				new ExactRun("field 0,3", is("0")),
				quit()
		};
		sessionTest(runs, Input.getFile(ALL_TYPES_BOARD), ALL_TYPES_RULE, ALL_TYPES_SPEEDUP);
	}
}
