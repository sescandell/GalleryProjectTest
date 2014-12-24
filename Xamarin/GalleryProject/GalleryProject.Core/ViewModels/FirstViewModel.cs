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
            Pictures = new List<Picture>();
            for (var i = 0; i < 200; i++)
                Pictures.Add(new Picture()
                {
                    Name = i.ToString(),
                    SourceUrl = "http://lorempixel.com/1024/768/abstract/?v=" + i.ToString()
                });
        }

        public List<Picture> Pictures { get; private set; }
    }
}
