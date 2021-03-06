/*
    This file is part of Wicket-Contrib-TinyMce. See
    <http://http://wicketstuff.org/confluence/display/STUFFWIKI/wicket-contrib-tinymce>

    Wicket-Contrib-TinyMce is free software: you can redistribute it and/
    or modify it under the terms of the GNU Lesser General Public License
    as published by the Free Software Foundation, either version 3 of the
    License, or (at your option) any later version.

    Wicket-Contrib-TinyMce is distributed in the hope that it will be
    useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with Wicket-Contrib-TinyMce.  If not, see
    <http://www.gnu.org/licenses/>.
 */
package wicket.contrib.tinymce.settings;

import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.core.util.string.JavaScriptUtils;

import wicket.contrib.tinymce.InPlaceSaveBehavior;

/**
 * This plugin adds a save button that can be tied to the {@link InPlaceSaveBehavior}
 */
public class WicketSavePlugin extends Plugin
{
	private static final long serialVersionUID = 1L;
	private PluginButton saveButton;
	private PluginButton cancelButton;
	private String saveCallbackname;
	private String cancelCallbackname;
	private StringResourceModel saveMessage;

	public WicketSavePlugin(InPlaceSaveBehavior behavior)
	{
		super("wicketsave");
		saveButton = new PluginButton("save", this);
		cancelButton = new PluginButton("cancel", this);
		saveCallbackname = behavior.getSaveCallbackName();
		cancelCallbackname = behavior.getCancelCallbackName();
		saveMessage = new StringResourceModel("wicket_updating_mess", behavior.getTheComponent(),
			null);
	}

	public PluginButton getSaveButton()
	{
		return saveButton;
	}

	public PluginButton getCancelButton()
	{
		return cancelButton;
	}

	@Override
	protected void definePluginSettings(StringBuffer buffer)
	{
		super.definePluginSettings(buffer);
		buffer.append(",\n\tsave_onwicketsavecallback: '" + saveCallbackname + "'");
		buffer.append(",\n\tsave_onwicketcancelcallback: '" + cancelCallbackname + "'");
		buffer.append(",\n\twicket_updating_mess: '" +
			JavaScriptUtils.escapeQuotes(saveMessage.getString()) + "'");
	}
}
