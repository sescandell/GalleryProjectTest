using System.Collections.Generic;
using Cirrious.MvvmCross.ViewModels;
using GalleryProject.Core.Model;

namespace GalleryProject.Core.ViewModels
{
    public class FirstViewModel
        : MvxViewModel
    {
        public FirstViewModel()
        {
            Items = new List<Picture>();
            for (var i = 0; i < 200; i++)
                Items.Add(new Picture()
                {
                    Name = i.ToString(),
                    SourceUrl = "http://lorempixel.com/1024/768/abstract/?v=" + i.ToString()
                });
        }

        public List<Picture> Items { get; private set; }
    }
}
