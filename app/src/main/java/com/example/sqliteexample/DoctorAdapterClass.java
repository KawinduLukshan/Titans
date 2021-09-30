package com.example.sqliteexample;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DoctorAdapterClass extends RecyclerView.Adapter<DoctorAdapterClass.ViewHolderDoctor> {

    List<DoctorModelClass> doctor;
    Context context;
    DatabaseHelperConnectClass databaseHelperClass;

    public DoctorAdapterClass(List<DoctorModelClass> doctor, Context context) {
        this.doctor = doctor;
        this.context = context;
        databaseHelperClass = new DatabaseHelperConnectClass(context);
    }

    @NonNull
    @Override
    public ViewHolderDoctor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.doctor_item_list,parent,false);
        ViewHolderDoctor viewHolder = new ViewHolderDoctor(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderDoctor holder, @SuppressLint("RecyclerView") final int position) {
        final DoctorModelClass doctorModelClass = doctor.get(position);

        holder.textViewID.setText(Integer.toString(doctorModelClass.getId()));
        holder.editText_Name.setText(doctorModelClass.getName());
        holder.editText_Email.setText(doctorModelClass.getEmail());
        holder.editText_Hospital.setText(doctorModelClass.getHospital());
        holder.editText_Specialization.setText(doctorModelClass.getSpecialization());
        holder.editText_Contactnumber.setText(doctorModelClass.getContactnumber());



      //Edit

        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = holder.editText_Name.getText().toString();
                String stringEmail = holder.editText_Email.getText().toString();
                String stringHospital = holder.editText_Hospital.getText().toString();
                String stringSpecialization = holder.editText_Specialization.getText().toString();
                String stringContactnumber = holder.editText_Contactnumber.getText().toString();





                databaseHelperClass.updateDoctor(new DoctorModelClass(doctorModelClass.getId(),stringName,stringEmail,stringHospital,stringSpecialization,stringContactnumber));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });
       //Delete
        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deleteDoctor(doctorModelClass.getId());
                doctor.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return doctor.size();
    }

    public class ViewHolderDoctor extends RecyclerView.ViewHolder{
        TextView textViewID;
        EditText editText_Name;
        EditText editText_Email;
        EditText editText_Hospital;
        EditText editText_Specialization;
        EditText editText_Contactnumber;



        Button button_Edit;
        Button button_delete;
        //View

        public ViewHolderDoctor(@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.text_id);
            editText_Name = itemView.findViewById(R.id.edittext_name);
            editText_Email = itemView.findViewById(R.id.edittext_email);
            editText_Hospital = itemView.findViewById(R.id.edittext_hospital);
            editText_Specialization= itemView.findViewById(R.id.edittext_specialization);
            editText_Contactnumber = itemView.findViewById(R.id.edittext_contactnumber);




            button_delete = itemView.findViewById(R.id.button_delete);
            button_Edit = itemView.findViewById(R.id.button_edit);

        }

    }



}

