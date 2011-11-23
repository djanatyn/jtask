jtask - java task manager
=========================

AUTHORS
-------
Jonathan Strickland

CHANGELOG
---------

* 2011-11-12 20:13:50: changed structure, added Prompt class
* 2011-11-12 21:07:13: got everything compiling
* 2011-11-12 21:47:06: implemented saving to files
* 2011-11-12 22:31:08: implemented adding tasks, quitting, finalized file format
* 2011-11-12 22:41:40: implemented toggling, purging
* 2011-11-12 22:52:20: finalized adding new tasks
* 2011-11-12 00:19:17: completed project

USAGE
-----
jtask is a task manager written in java that can be used to organize your life using a simple interactive interface.

When using jtask, remember to use list before running commands so you know which tasks to manipulate.

Each command is documented below:

### quit

    quits the program and prompts the user whether or not to save if there are unsaved changes

### add

    prompts the user to enter information and add a new task to the list

### remove

    prompts the user for the number of a task to delete

### list

    lists all the tasks and their numbers to the user

### save

    saves all changes to disk

### toggle

    toggles an item from either complete to todo, or todo to complete

### purge

    removes all completed items (not reversible)

### help

    lists all commands and their uses


INSTALL
-------
Simply compile all of the included files, and run JTask.

BUGS
----
The program might not respond very nicely if you try typing in weird things for the tasks. Try to keep it friendly.

