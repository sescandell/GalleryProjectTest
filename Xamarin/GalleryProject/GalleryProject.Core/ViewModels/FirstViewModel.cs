using System.Collections.Generic;
using Cirrious.MvvmCross.ViewModels;

namespace GalleryProject.Core.ViewModels
{
    public class FirstViewModel 
		: MvxViewModel
    {
		private List<string> _items = null;
        public List<string> Items
		{
            get
            {
                if (null != _items) return _items;

                _items = new List<string>();
                for (var i=0; i<200; i++)
                    _items.Add("http://lorempixel.com/1024/768/abstract/?v=" + i.ToString());

                return _items;
            }
		}
    }
}
