package io.shilan.wicket.pages.layout.js;

import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.resource.JQueryPluginResourceReference;

/**
 * Provides the {@link ResourceReference} for the Kendo UI (all) library.
 * Based on https://github.com/sebfz1/wicket-jquery-ui/issues/318
 */
public class KendoAllResourceReference extends JQueryPluginResourceReference
{
	private static final long serialVersionUID = 1L;

	private static final KendoAllResourceReference INSTANCE = new KendoAllResourceReference();

	/**
	 * Private constructor
	 */
	private KendoAllResourceReference()
	{
		super(KendoAllResourceReference.class, "kendo.all.min.js");
	}

	/**
	 * Gets the instance of the resource reference
	 *
	 * @return the single instance of the resource reference
	 */
	public static KendoAllResourceReference get()
	{
		return INSTANCE;
	}
}