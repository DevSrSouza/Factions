package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Factions;
import com.massivecraft.factions.Perm;

public class CmdCape extends FCommand
{
	public CmdCapeGet cmdCapeGet = new CmdCapeGet();
	public CmdCapeSet cmdCapeSet = new CmdCapeSet();
	public CmdCapeRemove cmdCapeRemove = new CmdCapeRemove();
	
	public CmdCape()
	{
		super();
		this.aliases.add("cape");
		
		this.permission = Perm.CAPE.node;
		
		senderMustBePlayer = false;
		senderMustBeMember = false;
		senderMustBeOfficer = false;
		senderMustBeLeader = false;
		
		this.addSubCommand(this.cmdCapeGet);
		this.addSubCommand(this.cmdCapeSet);
		this.addSubCommand(this.cmdCapeRemove);
	}
	
	@Override
	public void perform()
	{
		this.commandChain.add(this);
		Factions.get().cmdAutoHelp.execute(this.sender, this.args, this.commandChain);
	}
	
}